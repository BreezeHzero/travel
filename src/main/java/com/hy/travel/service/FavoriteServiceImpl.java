package com.hy.travel.service;

import com.hy.travel.dao.FavoriteDao;
import com.hy.travel.model.*;

import java.util.ArrayList;
import java.util.List;

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
 * @created 2020/1/20 21:46
 */
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao dao = new FavoriteDao();
    @Override
    public boolean isFavorite(int uid, int rid) {
        List<Favorite> list = new ArrayList<>();
        list = dao.findFavoriteByUidAndRid(uid, rid);
        boolean flag = false;

        if(list.isEmpty()){
            //如果为空
            flag = false;
        }else{
            flag = true;
        }
        return flag;
    }

    /**
     * 添加收藏
     * @param uid
     * @param rid
     * @return
     */
    @Override
    public boolean addFavorite(int uid, int rid) {
        return dao.addFavorite(uid, rid);
    }

    /**
     * 取消收藏
     * @param uid
     * @param rid
     * @return
     */
    @Override
    public boolean cancelFavorite(int uid, int rid) {
        return dao.cancelFavorite(uid,rid);
    }

    /**
     * 我的收藏 分页
     * @param uid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<MyFavorite> pageQuery(int uid, int currentPage, int pageSize) {
        PageBean<MyFavorite> pb = new PageBean<MyFavorite>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = dao.getTotalCount(uid);
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * pageSize;
        //存放每页数据
        pb.setList(dao.findMyFavorite(uid,start,pageSize));

        //计算总页数
        int totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPageCount);

        return pb;
    }

    /**
     * 总页数
     * @param uid
     * @return
     */
    @Override
    public int getTotalCount(int uid) {
        return dao.getTotalCount(uid);
    }

    /**
     *
     * @param rname
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<MyFavorite> pageQuery(String rname,double gt_price,double lt_price, int currentPage, int pageSize) {
        PageBean<MyFavorite> pb = new PageBean<MyFavorite>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = dao.getFavoriteTotalCount(rname,gt_price,lt_price);
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * pageSize;
        //存放每页数据
        pb.setList(dao.findFavoriteNum(rname,gt_price,lt_price,start,pageSize));

        //计算总页数
        int totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPageCount);

        return pb;
    }

    /**
     *
     * @return
     */
    @Override
    public int getFavoriteTotalCount(String rname,double gt_price,double lt_price) {
        return dao.getFavoriteTotalCount(rname,gt_price,lt_price);
    }

    /**
     * 热门推荐
     * @return
     */
    @Override
    public List<MyFavorite> hotRecommend() {
        return dao.randFind();
    }
}
