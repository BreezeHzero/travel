package com.hy.travel.mapper;

import com.hy.travel.dao.UserDao;
import com.hy.travel.model.User;
import org.junit.Test;

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
 * @created 2020/1/3 21:05
 */
public class UserTest {
    UserDao dao = new UserDao();
    /*@Test
    public void test(){
        User user = new User(0,"aaa","123","name","1923-2-10","男","1336546531","27897@163.com","1","1");
        int flag = dao.registUser(user);
    }*/

    @Test
    public void test(){
        String a = "aaa";
        List<User> byUsername = dao.findByUsername(a);
        for (User user : byUsername) {
            System.out.println(user);
        }
    }
}
