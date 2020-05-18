package com.hy.travel.service;

import com.hy.travel.dao.TourguideDao;
import com.hy.travel.model.Tourguide;

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
 * @created 2020/4/13 11:46
 */
public class TourguideServiceImpl implements TourguideService {
    private TourguideDao dao = new TourguideDao();
    @Override
    public List<Tourguide> findAll() {
        return dao.findAll();
    }

    @Override
    public Tourguide findTourguideByid(int tid) {
        return dao.findTourguideByid(tid);
    }
}
