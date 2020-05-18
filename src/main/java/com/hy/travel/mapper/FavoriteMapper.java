package com.hy.travel.mapper;

import com.hy.travel.model.Favorite;
import com.hy.travel.model.MyFavorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Title:com.hy.travel.mapper
 * Description: 描述【
 * <p>
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/1/20 21:40
 */
public interface FavoriteMapper {
    /**
     * 判断用户是否收藏过
     * @param uid 用户id
     * @param rid 线路id
     * @return
     */
    public List<Favorite> findFavoriteByUidAndRid(@Param("uid") int uid , @Param("rid") int rid);

    /**
     * 添加收藏
     * @param uid
     * @param rid
     * @return
     */
    public boolean insertFavorite(@Param("uid") int uid, @Param("rid") int rid);

    /**
     * 取消收藏
     * @param uid
     * @param rid
     * @return
     */
    public boolean deleteFavorite(@Param("uid") int uid, @Param("rid") int rid);

    /**
     * 我的收藏
     * @param uid 用户id
     * @return
     */
    public List<MyFavorite> findMyFavorite(@Param("uid") int uid, @Param("start") int start, @Param("pageSize") int pageSize);

    /**
     * 我的收藏总数
     * @param uid  用户id
     * @return
     */
    public int getTotalCount(int uid);

    /**
     * 统计收藏次数
     * @param start
     * @param pageSize
     * @return
     */
    public List<MyFavorite> findFavoriteNum(@Param("rname") String rname, @Param("gt_price") double gt_price,@Param("lt_price") double lt_price, @Param("start") int start, @Param("pageSize") int pageSize);

    /**
     * 收藏表的总数
     * @return
     */
    public int getFavoriteTotalCount(@Param("rname") String rname, @Param("gt_price") double gt_price,@Param("lt_price") double lt_price);

    /**
     * 人气旅游查询
     * @return
     */
    public List<MyFavorite> randFind();

    /**
     * 最新旅游查询
     * @return
     */
    public List<MyFavorite> randFind_new();

}
