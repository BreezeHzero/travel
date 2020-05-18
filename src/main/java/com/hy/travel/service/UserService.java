package com.hy.travel.service;

import com.hy.travel.model.User;

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
public interface UserService {

    /**
     * 注册用户信息
     * @param user 用户信息
     */
    boolean registUser(User user);

    /**
     * 激活
     * @param code 激活码
     * @return 激活成功为true，否则为false
     */
    boolean active(String code);

    User login(String username, String password);
}
