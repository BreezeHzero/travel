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
 * @created 2020/4/13 11:09
 */
public class Tourguide {
    private int tid;
    private String tname;//姓名
    private String sex;//性别
    private String birthday;//出生日期
    private String title;//标题
    private String telephone;//手机号
    private String email;//邮箱
    private String status;//Y代表有时间，N代表没时间
    private String timage;//图片
    private String tinfo;//个人简介
    private String worktime;//入职时间

    public Tourguide() {
    }

    public Tourguide(int tid, String tname, String sex, String birthday, String title, String telephone, String email, String status, String timage, String tinfo, String worktime) {
        this.tid = tid;
        this.tname = tname;
        this.sex = sex;
        this.birthday = birthday;
        this.title = title;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
        this.timage = timage;
        this.tinfo = tinfo;
        this.worktime = worktime;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimage() {
        return timage;
    }

    public void setTimage(String timage) {
        this.timage = timage;
    }

    public String getTinfo() {
        return tinfo;
    }

    public void setTinfo(String tinfo) {
        this.tinfo = tinfo;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }
}
