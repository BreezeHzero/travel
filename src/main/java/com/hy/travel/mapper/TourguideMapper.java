package com.hy.travel.mapper;

import com.hy.travel.model.Tourguide;

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
 * @created 2020/4/13 11:36
 */
public interface TourguideMapper {
    /**
     *
     * @return
     */
    public List<Tourguide> findAll();

    public Tourguide findTourguideByid(int tid);
}
