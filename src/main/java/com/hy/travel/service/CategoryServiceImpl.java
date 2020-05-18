package com.hy.travel.service;

import com.hy.travel.dao.CategoryDao;
import com.hy.travel.model.Category;
import com.hy.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Title:com.hy.travel.service
 * Description: 描述【
 * <p>
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/1/14 13:50
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDao();

    @Override
    public List<Category> findAll() {
        //从Jedis缓存中查询
        //1. 获取Jedis客户端
        Jedis jedis = null;
        Set<Tuple> categorys = null;
        List<Category> list = null;
        try {
            jedis = JedisUtil.getJedis();
            //2. 使用sortedset排序查询,0到-1是查询所有
            //Set<String> categorys = jedis.zrange("category", 0, -1);
            categorys = jedis.zrangeWithScores("category", 0, -1);
            if(categorys == null || categorys.size() == 0){
                //如果为空，从数据库中查询，再存到redis缓存中
                list = dao.findAll();
                for (int i = 0; i < list.size(); i++) {
                    jedis.zadd("category",list.get(i).getCid(),list.get(i).getCname());
                }
            }else{
                //如果不为空，将set存到list中
                list = new ArrayList<Category>();
                for (Tuple tuple : categorys) {
                    Category categoryList = new Category();
                    categoryList.setCname(tuple.getElement());
                    categoryList.setCid((int)tuple.getScore());
                    list.add(categoryList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }

        return list;
    }

    @Override
    public Category findCategoryByCid(int cid) {
        return dao.findCategoryByCid(cid);
    }
}
