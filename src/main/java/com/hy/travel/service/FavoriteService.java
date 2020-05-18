package com.hy.travel.service;

import com.hy.travel.model.MyFavorite;
import com.hy.travel.model.PageBean;

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
public interface FavoriteService {
    /**
     * 判断用户是否收藏
     * @param uid
     * @param rid
     * @return
     */
    boolean isFavorite(int uid, int rid);

    /**
     * 添加收藏
     * @param uid
     * @param rid
     * @return
     */
    boolean addFavorite(int uid, int rid);

    /**
     * 取消收藏
     * @param uid
     * @param rid
     * @return
     */
    boolean cancelFavorite(int uid, int rid);


    PageBean<MyFavorite> pageQuery(int uid, int currentPage, int pageSize);

    /**
     * 总页数
     * @param uid
     * @return
     */
    int getTotalCount(int uid);

    /**
     * 收藏排行
     * @param rname
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<MyFavorite> pageQuery(String rname,double gt_price,double lt_price, int currentPage, int pageSize);

    /**
     * 总页数
     * @return
     */
    int getFavoriteTotalCount(String rname,double gt_price,double lt_price);

    /**
     * 热门推荐
     * @return
     */
    List<MyFavorite> hotRecommend();
}
