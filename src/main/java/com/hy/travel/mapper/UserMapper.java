package com.hy.travel.mapper;

import com.hy.travel.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Title:com.hy.travel.mapper
 * Description: 描述【
 * <p>
 *      用户信息相关接口
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/1/3 17:38
 */
public interface UserMapper {
    /**
     * 注册用户信息，保存用户信息
     * @param user 用户信息
     */
    int registUser(User user);

    /**
     * 查找用户名 通过用户名
     * @param username 用户名
     * @return 返回查找出来的信息
     */
    List<User> findByUsername(String username);

    /**
     * 根据激活码查找到注册的用户
     * @param code 激活码
     * @return 用户信息
     */
    User findUserByCode(String code);

    /**
     * 根据用户id修改用户状态status为Y
     * @param uid 用户id
     * @return 修改成功返回true，否则为false
     */
    boolean updateStatus(int uid);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
