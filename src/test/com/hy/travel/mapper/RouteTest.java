package com.hy.travel.mapper;

import com.hy.travel.dao.RouteDao;
import com.hy.travel.model.Route;
import org.junit.Test;

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
 * @created 2020/1/18 22:01
 */
public class RouteTest {
    RouteDao dao = new RouteDao();
    @Test
    public void test(){
        int a = dao.getTotalCount(5, "西安");
        System.out.println(a);
    }

    @Test
    public void test2(){
        List<Route> list = dao.findByPage(2, 0, 10, "西安");
        for (int i = 0; i < list.size(); i++) {
            Route route = list.get(i);
            System.out.println(route);
        }
    }

    @Test
    public void test3(){
        List<Route> routes = dao.randomSelect();
        for (int i = 0; i < routes.size(); i++) {
            Route route = routes.get(i);
            System.out.println(route);
        }
    }

    @Test
    public void test4(){
        List<Route> routes = dao.randomCheapTravel();
        for (int i = 0; i < routes.size(); i++) {
            Route route = routes.get(i);
            System.out.println(route);
        }
    }
}
