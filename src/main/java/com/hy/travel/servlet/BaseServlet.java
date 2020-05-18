package com.hy.travel.servlet;

import com.alibaba.fastjson.JSON;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Title:${PACKAGE_NAME}
 * Description: 描述【
 * <p>  基servlet分发请求路径，抽取出来共性代码进行封装
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/1/13 23:40
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
        //获取请求路径
        String uri = req.getRequestURI();
        //获取方法名称
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);
        //获取方法对象Method
        //service方法被谁调用，就指的是谁的方法
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将结果json格式发送
     * @param obj
     * @param request
     * @param response
     * @throws IOException
     */
    public void writeValue(Object obj,HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(JSON.toJSON(obj));
        response.getWriter().close();
    }
}
