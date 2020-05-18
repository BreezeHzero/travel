package com.hy.travel.service;

import com.hy.travel.model.PageBean;
import com.hy.travel.model.Route;

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
 * @created 2020/1/15 15:38
 */
public interface RouteService {
     PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

     Route findOne(int rid);

    /**
     * 随机推荐
     * @return
     */
     List<Route> randomRecommend();

    /**
     * 主题旅游
     * @return
     */
     List<Route> randomSelect_theme();

    /**
     * 特价游
     * @return
     */
     List<Route> randomCheapTravel();
}
