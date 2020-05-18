package com.hy.travel.dao;

import com.hy.travel.mapper.TourguideMapper;
import com.hy.travel.model.Tourguide;
import com.hy.travel.util.DButil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
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
 * @created 2020/4/13 11:42
 */
public class TourguideDao {

    public List<Tourguide> findAll(){
        List<Tourguide> list = new ArrayList<>();
        SqlSession session = null;

        try {
            session = DButil.getSession();
            TourguideMapper mapper = session.getMapper(TourguideMapper.class);
            list = mapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return list;
    }

    public Tourguide findTourguideByid(int tid){
        SqlSession session = null;
        Tourguide tourguide = null;
        try {
            session = DButil.getSession();
            TourguideMapper mapper = session.getMapper(TourguideMapper.class);
            tourguide = mapper.findTourguideByid(tid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return tourguide;
    }
}
