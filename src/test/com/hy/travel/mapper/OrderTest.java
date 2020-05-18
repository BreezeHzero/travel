package com.hy.travel.mapper;

import com.hy.travel.dao.OrderDao;
import com.hy.travel.model.Order;
import org.junit.Test;

import java.util.Iterator;
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
 * @created 2020/4/15 15:13
 */
public class OrderTest {
    private OrderDao dao = new OrderDao();
    @Test
    public void test(){
        List<Order> orders = dao.allComments(65);
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()){
            Order next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void test2(){
        List<Order> countOfEveryRoute = dao.findCountOfEveryRoute();
        Iterator<Order> iterator = countOfEveryRoute.iterator();
        while(iterator.hasNext()){
            Order next = iterator.next();
            System.out.println(next.getOrdernum());
        }
    }
}
