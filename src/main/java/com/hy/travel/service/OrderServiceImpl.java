package com.hy.travel.service;

import com.hy.travel.dao.OrderDao;
import com.hy.travel.model.Order;
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
 * @created 2020/4/14 15:23
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao dao = new OrderDao();

    @Override
    public boolean submitOrder(int oid, int uid, int rid, String order_num, String comments, int tid) {
        return dao.insertOrder(oid,uid,rid,order_num,comments,tid);
    }

    @Override
    public List<Order> haveBuy(int rid) {
        return dao.findUidByRid(rid);
    }

    @Override
    public List<Route> findHaveBuyByUid(int uid) {
        return dao.findHaveBuyByUid(uid);
    }

    @Override
    public boolean insertComments(String comments, int uid, int rid) {
        return dao.insertComments(comments,uid,rid);
    }

    @Override
    public List<Order> allComments(int rid) {
        return dao.allComments(rid);
    }

    @Override
    public List<Order> findCommentByUidAndRid(int uid, int rid) {
        return dao.findCommentByUidAndRid(uid, rid);
    }

    @Override
    public int countComments(int rid) {
        return dao.countComments(rid);
    }

    @Override
    public List<Order> findCommentsByUid(int uid) {
        return dao.findCommentsByUid(uid);
    }

    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Order> findCountOfEveryRoute() {
        return dao.findCountOfEveryRoute();
    }

    @Override
    public Order findOrder_num(int uid, int rid) {
        return dao.findOrder_num(uid, rid);
    }

    @Override
    public Order findOid(String serialId) {
        return dao.findOid(serialId);
    }
}
