package com.hy.travel.dao;

import com.hy.travel.mapper.ServiceMapper;
import com.hy.travel.model.Service;
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
 * @created 2020/4/12 16:42
 */
public class ServiceDao {

    /**
     *
     * @return
     */
    public List<Service> findAll(){
        List<Service> list = new ArrayList<>();
        SqlSession session = null;
        try {
            session = DButil.getSession();
            ServiceMapper mapper = session.getMapper(ServiceMapper.class);
            list = mapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return list;
    }

    /**
     *
     * @param serid
     * @return
     */
    public Service findAnswerBySerid(int serid){
        Service service = new Service();
        SqlSession session = null;
        try {
            session = DButil.getSession();
            ServiceMapper mapper = session.getMapper(ServiceMapper.class);
            service = mapper.findAnswerBySerid(serid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return service;
    }
}
