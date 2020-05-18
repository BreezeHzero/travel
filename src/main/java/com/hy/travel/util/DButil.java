package com.hy.travel.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * <p>
 * Title:com.hy.util
 * </p>
 * <p/>
 * <p>
 * Description: 描述【】
 * </p>
 * <p/>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * <p/>
 * <p>
 * Company: 太原工业学院
 * </p>
 *
 * @author hanyang
 * @version 1.0
 * @created 2019/11/7 11:17
 */
public class DButil {
    public static SqlSessionFactory sessionFactory;
    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("Mybatis-config.xml");
            //sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sessionFactory = builder.build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 创建能执行映射文件中sql的sqlSession
     * @return 执行sql的sqlSession对象
     */
    public static SqlSession getSession(){
        return sessionFactory.openSession(true);
    }

    /**
     * 关闭session释放资源
     * @param session 要被关闭的session对象
     */
    public static void closeSession(SqlSession session){
        if(session != null){
            session.close();
        }
    }
}
