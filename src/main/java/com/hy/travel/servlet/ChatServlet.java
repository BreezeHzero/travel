package com.hy.travel.servlet;

import com.hy.travel.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Title:com.hy.travel.servlet
 * Description: 描述【
 * <p>
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/4/11 23:32
 */

@WebServlet("/chat/*")
public class ChatServlet extends BaseServlet {
    private static final long serialVersionUID = 2L;
    //private ServiceService serviceService = new ServiceServiceImpl();

    //存储在线用户
    //List<String> OnLineUserList = new ArrayList<String>();
    //存储聊天内容的arrayList
    static List<String> strSendConentList=new ArrayList<String>();

    /**
     * 所有的聊天记录，获取聊天记录，实际上是服务器发送数据到界面
     * @param request
     * @param response
     * @throws IOException
     */
    public void allChatList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String msg = "";
        if(strSendConentList.size() != 0){
            Iterator<String> it=strSendConentList.iterator();
            while(it.hasNext()){
                msg += it.next() + "</br>";
            }
        }
        msg = msg.replace("<:", "<img src='Face/");
        msg = msg.replace(":>", ".gif '/>");
        writeValue(msg,request,response);
    }

    /**
     * 发送消息, 实际上是把消息发送给服务器，存储在集合中
     * @param request
     * @param response
     * @throws IOException
     */
    public void addSendContent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取聊天内容
        String strContent = request.getParameter("content");
        //获取用户
//        User user = (User)request.getSession().getAttribute("user");
        Object user = request.getSession().getAttribute("user");

        String strSendConent;
        int i = 0;
        if(user == null){
            strSendConent = "游客" + ++i + new java.util.Date(System.currentTimeMillis()) + " : " + strContent;
        }else{
            strSendConent =   ((User) user).getName()+ new java.util.Date(System.currentTimeMillis()) + " : " + strContent;
        }

        if (strSendConentList.size() == 0)
        {
            strSendConentList = new ArrayList<String>();
        }
        boolean flag = strSendConentList.add(strSendConent);
        writeValue(flag,request,response);
    }

    /**
     * 退出，清除记录
     * @param request
     * @param response
     * @throws IOException
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        strSendConentList.clear();
        boolean flag = false;
        if(strSendConentList.size() == 0){
            flag = true;
        }
        writeValue(flag,request,response);
    }

}
