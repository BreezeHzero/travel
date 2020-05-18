package com.hy.travel.dao;

import com.hy.travel.mapper.UserMapper;
import com.hy.travel.model.User;
import com.hy.travel.util.DButil;
import org.apache.ibatis.session.SqlSession;

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
 * @created 2020/1/3 17:57
 */
public class UserDao {
    /**
     * 注册用户信息
     * @param user
     * @return
     */
    public int registUser(User user){
        int flag = 0;
        SqlSession session = null;
        try {
            session = DButil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            flag = mapper.registUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return flag;
    }

    /**
     * 通话用户名查找用户名信息
     * @param username
     * @return
     */
    public List<User> findByUsername(String username){
        List<User> list = new ArrayList<>();
        SqlSession session = null;
        try {
            session = DButil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            list = mapper.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return list;
    }

    /***
     * 根据激活码查找到注册的用户
     * @param code 激活啊
     * @return 返回用户信息
     */
    public User findUserByCode(String code){
        User user = new User();
        SqlSession session = null;
        try {
            session = DButil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            user = mapper.findUserByCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return user;
    }

    /**
     * 根据uid修改用户状态
     * @param uid 用户id
     * @return 修改成功返回true，失败返回false
     */
    public boolean updateStatus(int uid){
        SqlSession session = null;
        boolean flag = false;
        try {
            session = DButil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            flag = mapper.updateStatus(uid);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return flag;
    }

    /**
     * 查到单个用户信息
     * @param username
     * @param password
     * @return
     */
    public User findUserByUsernameAndPassword(String username, String password){
        User user = new User();
            SqlSession session = null;
        try {
            session = DButil.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            user = mapper.findUserByUsernameAndPassword(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return user;
    }
}
