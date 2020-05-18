package com.hy.travel.dao;

import com.hy.travel.mapper.OrderMapper;
import com.hy.travel.model.Order;
import com.hy.travel.model.Route;
import com.hy.travel.util.DButil;
import org.apache.ibatis.session.SqlSession;
import org.omg.CORBA.ORB;

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
 * @created 2020/4/14 15:18
 */
public class OrderDao {

    public boolean insertOrder(int oid, int uid, int rid, String order_num, String comments,int tid){
        SqlSession session = null;
        boolean flag = false;
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            flag = mapper.insertOrder(oid, uid, rid, order_num, comments, tid);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }

    public List<Order> findUidByRid(int rid){
        SqlSession session = null;
        List<Order> list = new ArrayList<>();
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            list = mapper.findUidByRid(rid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public List<Route> findHaveBuyByUid(int uid){
        SqlSession session = null;
        List<Route> list = new ArrayList<>();
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            list = mapper.findHaveBuyByUid(uid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public boolean insertComments(String comments, int uid, int rid){
        SqlSession session = null;
        boolean flag = false;
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            flag = mapper.insertComments(comments, uid, rid);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }

    public List<Order> allComments(int rid){
        SqlSession session = null;
        List<Order> list = new ArrayList<>();
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            list = mapper.allComments(rid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public List<Order> findCommentByUidAndRid(int uid, int rid){
        SqlSession session = null;
        List<Order> list = new ArrayList<>();
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            list = mapper.findCommentByUidAndRid(uid, rid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public int countComments(int rid){
        SqlSession session = null;
        int count = 0;
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            count = mapper.countComments(rid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count;
    }

    public List<Order> findCommentsByUid(int uid){
        SqlSession session = null;
        List<Order> list = new ArrayList<>();
        int count = 0;
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            list = mapper.findCommentsByUid(uid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public List<Order> findAll(){
        SqlSession session = null;
        List<Order> list = new ArrayList<>();
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            list = mapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public List<Order> findCountOfEveryRoute(){
        SqlSession session = null;
        List<Order> list = new ArrayList<>();
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            list = mapper.findCountOfEveryRoute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public Order findOrder_num(int uid, int rid){
        SqlSession session = null;
        Order order = null;
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            order = mapper.findOrder_num(uid, rid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return order;
    }

    public Order findOid(String serialId) {
        SqlSession session = null;
        Order order = null;
        try {
            session = DButil.getSession();
            OrderMapper mapper = session.getMapper(OrderMapper.class);
            order = mapper.findOid(serialId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return order;
    }
}
