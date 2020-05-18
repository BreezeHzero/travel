package com.hy.travel.model;

/**
 * Title:com.hy.travel.model
 * Description: 描述【
 * <p>      订单流水
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/4/25 8:39
 */
public class Serial {
    private int  id;
    private String serialId;
    private int oid;
    private int rid;
    private double payment;
    private String payStype;
    private int peoCount;
    private String payTime;
    private String creTime;
    private int uid;

    public Serial() {
    }

    public Serial(int id, String serialId, int oid, int rid, double payment, String payStype, int peoCount, String payTime, String creTime, int uid) {
        this.id = id;
        this.serialId = serialId;
        this.oid = oid;
        this.rid = rid;
        this.payment = payment;
        this.payStype = payStype;
        this.peoCount = peoCount;
        this.payTime = payTime;
        this.creTime = creTime;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getPayStype() {
        return payStype;
    }

    public void setPayStype(String payStype) {
        this.payStype = payStype;
    }

    public int getPeoCount() {
        return peoCount;
    }

    public void setPeoCount(int peoCount) {
        this.peoCount = peoCount;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getCreTime() {
        return creTime;
    }

    public void setCreTime(String creTime) {
        this.creTime = creTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
