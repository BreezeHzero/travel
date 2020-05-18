package com.hy.travel.servlet;

import com.hy.travel.model.Tourguide;
import com.hy.travel.service.TourguideService;
import com.hy.travel.service.TourguideServiceImpl;

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
 * @created 2020/4/13 11:47
 */
@WebServlet("/tourguide/*")
public class TourguideServlet extends BaseServlet {
    private TourguideService service = new TourguideServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Tourguide> all = service.findAll();
        writeValue(all, request, response);
    }

    public void findTourguideByid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tidStr = request.getParameter("tid");
        int i = Integer.parseInt(tidStr);
        Tourguide tourguideByid = service.findTourguideByid(i);
        writeValue(tourguideByid,request,response);
    }
}
