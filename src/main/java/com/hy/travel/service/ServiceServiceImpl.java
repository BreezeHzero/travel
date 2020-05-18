package com.hy.travel.service;

import com.hy.travel.dao.ServiceDao;
import com.hy.travel.model.Service;

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
 * @created 2020/4/12 16:47
 */
public class ServiceServiceImpl implements ServiceService {
    private ServiceDao dao = new ServiceDao();

    @Override
    public List<Service> findAll() {
        return dao.findAll();
    }

    @Override
    public Service findAnswerBySerid(int serid) {
        return dao.findAnswerBySerid(serid);
    }
}
