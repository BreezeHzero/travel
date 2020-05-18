package com.hy.travel.mapper;

import com.hy.travel.model.Route;
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
 * @created 2020/1/15 15:43
 */
public interface RouteMapper {
    /**
     * 查询出总记录数
     * @param cid
     * @return
     */
    public int getTotalCount(@Param("cid") int cid, @Param("rname") String rname);

    /**
     * 根据分页查询出每页的记录
     * @param cid 类别id
     * @param start 开始页数
     * @param pageSize 每页条数
     * @return
     */
    public List<Route> findByPage(@Param("cid") int cid, @Param("start") int start, @Param("pageSize") int pageSize, @Param("rname") String rname);

    /**
     * 根据rid查询每个详细线路
     * @param rid
     * @return
     */
    public Route findOne(int rid);

    /**
     * 查询收藏次数
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);

    /**
     * 热门随机推荐
     * @return
     */
    public List<Route> randomSelect();

    /**
     * 主题推荐查询
     * @return
     */
    public List<Route> randomSelect_theme();

    /**
     * 特价游
     * @return
     */
    public List<Route> randomCheapTravel();
}
