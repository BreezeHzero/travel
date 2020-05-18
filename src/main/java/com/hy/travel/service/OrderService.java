package com.hy.travel.service;

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
 * @created 2020/4/14 15:22
 */
public interface OrderService {
     boolean submitOrder(int oid, int uid, int rid, String order_num, String comments, int tid);

     List<Order> haveBuy(int rid);

     List<Route> findHaveBuyByUid(int uid);

     boolean insertComments(String comments, int uid, int rid);

     List<Order> allComments(int rid);

     List<Order> findCommentByUidAndRid(int uid, int rid);

     int countComments(int rid);

     List<Order> findCommentsByUid(int uid);

     List<Order> findAll();

     List<Order> findCountOfEveryRoute();

     Order findOrder_num(int uid, int rid);

     Order findOid(String serialId);
}
