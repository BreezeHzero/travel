package com.hy.travel.dao;

import com.hy.travel.mapper.CategoryMapper;
import com.hy.travel.model.Category;
import com.hy.travel.util.DButil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Title:com.hy.travel.dao
 * Description: 描述【
 * <p>
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/1/14 13:46
 */
public class CategoryDao {
    /**
     * 查找Category全部信息
     * @return id和name
     */
    public List<Category> findAll(){
        SqlSession session = null;
        List<Category> all = null;
        try {
            session = DButil.getSession();
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            all = mapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return all;
    }

    public Category findCategoryByCid(int cid){
        SqlSession session = null;
        Category category = null;
        try {
            session = DButil.getSession();
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            category = mapper.findCategoryByCid(cid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return category;
    }
}
