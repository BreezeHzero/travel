package com.hy.travel.servlet;

import com.hy.travel.model.Order;
import com.hy.travel.model.Route;
import com.hy.travel.model.User;
import com.hy.travel.service.OrderService;
import com.hy.travel.service.OrderServiceImpl;
import com.hy.travel.service.SerialService;
import com.hy.travel.service.SerialServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static org.apache.ibatis.ognl.DynamicSubscript.all;

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
 * @created 2020/4/14 15:27
 */
@WebServlet("/order/*")
public class OrderServlet extends BaseServlet{
    private OrderService service = new OrderServiceImpl();
    private SerialService serialService = new SerialServiceImpl();

    public void submitOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ridStr = request.getParameter("rid");
        String tidStr = request.getParameter("tid");
        int rid = Integer.parseInt(ridStr);
        int tid = Integer.parseInt(tidStr);
        String order_num = UUID.randomUUID().toString();
        User user = (User)request.getSession().getAttribute("user");

        request.getSession().setAttribute("rid",rid);
        request.getSession().setAttribute("order_num",order_num);

        int uid = 0;
        if(user == null){
            return;
        }else{
            uid = user.getUid();
        }

        boolean flag = service.submitOrder(0, uid, rid, order_num, "",tid);
        writeValue(flag,request,response);
    }

    public void confirmOrder(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int rid = (int)request.getSession().getAttribute("rid");
        String serialId = (String)request.getSession().getAttribute("order_num");
        User user = (User)request.getSession().getAttribute("user");

        Order oid = service.findOid(serialId);

        String paymentStr = request.getParameter("payment"); //金额
//        String payStype = request.getParameter("payStype");  //支付类型
        String peoCountStr = request.getParameter("peoCount"); //人数

        System.out.println(paymentStr);
        System.out.println(peoCountStr);


        double payment = Double.parseDouble(paymentStr);
        int peoCount = Integer.parseInt(peoCountStr);


        boolean flag = serialService.insertSerialOrder(serialId, oid.getOid(), rid, payment, "1", peoCount,user.getUid());
        writeValue(flag,request,response);
    }


    public void haveBuy(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String ridStr = request.getParameter("rid");
        int rid = Integer.parseInt(ridStr);
        List<Order> rids = service.haveBuy(rid);
        User user = (User)request.getSession().getAttribute("user");
        int uid = user.getUid();
        boolean flag = false;
        for (int i = 0; i < rids.size(); i++) {
            if(rids.get(i).getUid() == uid){
                //购买过
                flag = true;
            }
        }
        writeValue(flag,request,response);
    }

    public void findHaveBuyByUid(HttpServletRequest request, HttpServletResponse response) throws IOException{
        User user = (User) request.getSession().getAttribute("user");
        List<Route> routeList = service.findHaveBuyByUid(user.getUid());
        writeValue(routeList,request,response);
    }

    public void addComments(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String ridStr = request.getParameter("rid");
        String comments = request.getParameter("comments");
        int rid = Integer.parseInt(ridStr);
        User user = (User)request.getSession().getAttribute("user");
        int uid = user.getUid();

        boolean flag = service.insertComments(comments, uid, rid);
        writeValue(flag, request,response);
    }

    public void allComments(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String ridStr = request.getParameter("rid");
        int rid = Integer.parseInt(ridStr);
        List<Order> commentsList = service.allComments(rid);
        writeValue(commentsList,request,response);
    }
    
    public void findCommentByUidAndRid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ridStr = request.getParameter("rid");
        int rid = Integer.parseInt(ridStr);
        User user = (User)request.getSession().getAttribute("user");
        int uid = user.getUid();

        List<Order> singleComment = service.findCommentByUidAndRid(uid, rid);

        Iterator<Order> iterator = singleComment.iterator();
        while(iterator.hasNext()){
            Order next = iterator.next();
            System.out.println(next);
        }

        writeValue(singleComment,request,response);
    }

    public void countComments(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String ridStr = request.getParameter("rid");
        int rid = Integer.parseInt(ridStr);

        int count = service.countComments(rid);
        writeValue(count,request,response);
    }

    public void findCommentsByUid(HttpServletRequest request,HttpServletResponse response) throws IOException{
        User user = (User)request.getSession().getAttribute("user");
        int uid = user.getUid();

        List<Order> comments = service.findCommentsByUid(uid);
        writeValue(comments,request,response);
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        List<Order> all = service.findAll();
        writeValue(all, request, response);
    }

    public void findCountOfEveryRoute(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        List<Order> all = service.findCountOfEveryRoute();
        writeValue(all, request, response);
    }

    public void findOrder_num(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        User user = (User)request.getSession().getAttribute("user");
        int rid = (int)request.getSession().getAttribute("rid");

        Order order_num = service.findOrder_num(user.getUid(), rid);
        writeValue(order_num, request, response);
    }

    public void back(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        int rid = (int)request.getSession().getAttribute("rid");
        //销毁session
//        request.getSession().removeAttribute("rid");
        request.getSession().removeAttribute("serialId");
        //重定向
//        response.sendRedirect(request.getContextPath() + "/route_detail.html" + "?rid=" + rid);
        request.getSession().removeAttribute("rid");

        Object serialId = request.getSession().getAttribute("serialId");
        Object rid1 = request.getSession().getAttribute("rid");
        System.out.println("serialId" + serialId.toString());
        System.out.println("rid1" + rid1.toString());
    }

}
