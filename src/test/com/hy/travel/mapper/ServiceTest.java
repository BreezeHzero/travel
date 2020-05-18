package com.hy.travel.mapper;

import com.hy.travel.dao.ServiceDao;
import com.hy.travel.model.Service;
import org.junit.Test;

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
 * @created 2020/4/12 22:03
 */
public class ServiceTest {
    private ServiceDao dao = new ServiceDao();
    @Test
    public void test(){
        Service answerBySerid = dao.findAnswerBySerid(1);
        System.out.println(answerBySerid.getAnswer());
    }

}
