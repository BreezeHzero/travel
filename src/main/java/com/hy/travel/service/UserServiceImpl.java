package com.hy.travel.service;

import com.hy.travel.dao.UserDao;
import com.hy.travel.model.User;
import com.hy.travel.util.MailUtils;
import com.hy.travel.util.UuidUtil;

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
 * @created 2020/1/3 17:39
 */
public class UserServiceImpl implements UserService{
    UserDao udao = new UserDao();
    /**
     * 注册用户信息
     */
    @Override
    public boolean registUser(User user) {
        List<User> byUsername = udao.findByUsername(user.getUsername());
        if(!byUsername.isEmpty()){
            //用户名存在,注册失败
            return false;
        }else{
            ///设置激活码，uuid产生唯一字符串
            user.setCode(UuidUtil.getUuid());

            ///设置激活码状态，Y为激活，N为未激活
            //user.setStatus("N");
            ///激活邮件发送，邮件正文
            String content = "<a href='http://localhost:8080/travel/user/active?code="+user.getCode()+"'>点击激活，说走就走旅游网</a>";

            MailUtils.sendMail(user.getEmail(),content,"Email Activation");
            //用户名不存在,存储用户信息
            udao.registUser(user);
            return true;
        }
    }

    /**
     * 用户激活
     * @param code 激活码
     * @return 返回激活码
     */
    @Override
    public boolean active(String code) {
        User user = udao.findUserByCode(code);
        if(user != null){
            System.out.println("用户存在");
            //激活成功！
            udao.updateStatus(user.getUid());
            return true;
        }else{
            //激活失败
            System.out.println("用户不存在");
            return false;
        }

    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功，返回用户信息
     */
    @Override
    public User login(String username, String password) {
        return udao.findUserByUsernameAndPassword(username, password);
    }
}
