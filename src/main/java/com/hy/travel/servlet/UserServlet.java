package com.hy.travel.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hy.travel.model.ResultInfo;
import com.hy.travel.model.User;
import com.hy.travel.service.UserService;
import com.hy.travel.service.UserServiceImpl;
import com.hy.travel.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * Title:${PACKAGE_NAME}
 * Description: 描述【
 * <p>
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/1/13 23:49
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserService service = new UserServiceImpl();

    /**
     * 注册
     * @param request
     * @param response
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //从前台获取输入的验证码
        String checkCode = request.getParameter("check");
        //从session中取出随机生成的验证码，进行比较
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");

        System.out.println(checkcode_server);
        System.out.println(checkcode_server.equalsIgnoreCase("checkCode"));

        //一旦用户接收到了这个验证码，就立刻从session中移除这个验证码。保证验证码只使用一次
        session.removeAttribute("CHECKCODE_SERVER");


        //如果未输入验证码，或者验证码输入错误，则，注册失败
        if(checkCode == null || !checkcode_server.equalsIgnoreCase(checkCode)){
            //注册失败
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误!");

            writeValue(resultInfo,request,response);
            return;
        }

        String username = request.getParameter("username");
        String passwordStr = request.getParameter("password");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");

        String password = Md5Util.encodeByMd5(passwordStr);

        User user = new User(0,username,password,name,birthday,sex,telephone,email,"N",checkCode);
        boolean flag = service.registUser(user);
        ResultInfo resultInfo = new ResultInfo();
        if(flag){
            //为true，注册成功
            resultInfo.setFlag(true);
        }else{
            //为false，注册失败
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名已存在，注册失败");
        }
        writeValue(resultInfo,request,response);
    }

    /**
     * 激活
     * @param request
     * @param response
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");

        //前台获取用户激活码
        String code = request.getParameter("code");
        //激活操作
        boolean flag = service.active(code);
        if(flag){
            //激活成功
            request.getRequestDispatcher("../error/ok.html").forward(request,response);
        }else{
            //激活失败
            request.getRequestDispatcher("../error/500.html").forward(request,response);
        }
    }

    /**
     * 查找单个用户
     * @param request
     * @param response
     * @throws IOException
     */
    public void findSingleUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //LoginServlet中存储登录时检索的用户信息，存放在session中，键名为user，从session中获取登录的用户信息
        Object user = request.getSession().getAttribute("user");
        writeValue(user,request,response);
    }

    /**
     * 登录
     * @param request
     * @param response
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //验证码
        String checkCode = request.getParameter("check");
        //从session中取出随机生成的验证码进行比较
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");

        System.out.println(checkcode_server);
        System.out.println(checkcode_server.equalsIgnoreCase("checkCode"));

        //一旦用户接收到了这个验证码，就立刻从session中移除这个验证码。保证验证码只使用一次
        session.removeAttribute("CHECKCODE_SERVER");

        if(checkCode == null || !checkcode_server.equalsIgnoreCase(checkCode)){
            //登录失败
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误!");

            writeValue(resultInfo,request,response);
            return;
        }


        String username = request.getParameter("username");
        String passwordStr = request.getParameter("password");
        String remember_me = request.getParameter("remember_me");



        String password = Md5Util.encodeByMd5(passwordStr);

        User user = service.login(username, password);
        //将查出来的用户信息存储在session中，便于后期会话跟踪
        request.getSession().setAttribute("user",user);

        ResultInfo resultInfo = new ResultInfo();
        //判断
        //用户名或密码错误，用户不存在
        if(user == null){
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名或密码错误！");
        }

        //用户未激活
        if(user != null && !"Y".equals(user.getStatus())){
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户未激活，请激活");
        }
        //用户已激活
        if(user != null && "Y".equals(user.getStatus())){
            resultInfo.setFlag(true);
            resultInfo.setData(user);
        }


//        response.setHeader("Access-Control-Allow-Origin", "*");

        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("resultInfo",resultInfo);
        response.getWriter().println(jsonObject.toJSONString());*/
        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("resultInfo",resultInfo);
        String backFunction = request.getParameter("backFunction");
        response.getWriter().println(backFunction+"(" + jsonObject.toJSONString() + ")");*/

        writeValue(resultInfo,request,response);
    }

    /**
     * 退出
     * @param request
     * @param response
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //销毁session
        request.getSession().invalidate();
        //重定向
        response.sendRedirect(request.getContextPath() + "/login.html");
    }
}
