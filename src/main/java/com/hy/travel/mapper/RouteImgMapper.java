package com.hy.travel.mapper;

import com.hy.travel.model.RouteImg;

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
 * @created 2020/1/19 19:43
 */
public interface RouteImgMapper {
    /**
     * 根绝rid查询出图片的详细
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);
}
