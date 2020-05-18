package com.hy.travel.mapper;

import com.hy.travel.model.Order;
import com.hy.travel.model.Route;
import org.apache.ibatis.annotations.Param;

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
 * @created 2020/4/14 15:12
 */
public interface OrderMapper {

    /**
     * 插入订单
     * @param oid
     * @param uid
     * @param tid
     * @param rid
     * @param order_num
     * @param comments
     * @return
     */
    public boolean insertOrder(@Param("oid")int oid, @Param("uid")int uid, @Param("rid")int rid, @Param("order_num")String order_num, @Param("comments")String comments, @Param("tid")int tid);

    /**
     * 查询rid下的所有uid
     * @param rid
     * @return
     */
    public List<Order> findUidByRid(int rid);

    /**
     * 查看已购
     * @param uid
     * @return
     */
    public List<Route> findHaveBuyByUid(int uid);

    public boolean insertComments(@Param("comments")String comments, @Param("uid")int uid, @Param("rid")int rid);

    public List<Order> allComments(int rid);

    public List<Order> findCommentByUidAndRid(@Param("uid")int uid, @Param("rid")int rid);

    public int countComments(int rid);

    public List<Order> findCommentsByUid(int uid);

    public List<Order> findAll();

    public List<Order> findCountOfEveryRoute();

    Order findOrder_num(@Param("uid") int uid,
                        @Param("rid") int rid);

    Order findOid(String order_num);
}
