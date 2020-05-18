package com.hy.travel.model;

/**
 * Title:com.hy.travel.model
 * Description: 描述【
 * <p>
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/4/14 15:10
 */
public class Order {
    private int oid;
    private int uid;
    private int rid;//旅游线路
    private String order_date;//订单提交日期
    private String order_num;//订单号
    private String comments;//评论
    private int tid;//挑选的导游编号

    private String username;
    private String rname;
    private double price;
    private String rimage;

    private int ordernum;

    public Order() {
    }

    public Order(int oid, int uid, int rid, String order_num, String comments, int tid) {
        this.oid = oid;
        this.uid = uid;
        this.rid = rid;
        this.order_num = order_num;
        this.comments = comments;
        this.tid = tid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", rid=" + rid +
                ", order_date='" + order_date + '\'' +
                ", order_num='" + order_num + '\'' +
                ", comments='" + comments + '\'' +
                ", tid=" + tid +
                ", username='" + username + '\'' +
                '}';
    }
}
