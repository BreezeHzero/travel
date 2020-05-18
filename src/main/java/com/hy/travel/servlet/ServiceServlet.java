package com.hy.travel.servlet;

import com.hy.travel.model.Service;
import com.hy.travel.service.ServiceService;
import com.hy.travel.service.ServiceServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
 * @created 2020/4/12 16:49
 */
@WebServlet("/service/*")
public class ServiceServlet extends BaseServlet {
    private ServiceService ser = new ServiceServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Service> all = ser.findAll();
        writeValue(all, request ,response);
    }

    public void findAnswerBySerid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String serid = request.getParameter("serid");
        int i = Integer.parseInt(serid);
        //request.getSession().setAttribute("serid",i);
        Service answerBySerid = ser.findAnswerBySerid(i);
        writeValue(answerBySerid,request,response);
    }
}
