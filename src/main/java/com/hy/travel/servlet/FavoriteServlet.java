package com.hy.travel.servlet;

import com.hy.travel.model.MyFavorite;
import com.hy.travel.model.PageBean;
import com.hy.travel.service.FavoriteService;
import com.hy.travel.service.FavoriteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
 * @created 2020/1/25 12:24
 */
@WebServlet("/favoriteServlet/*")
public class FavoriteServlet extends BaseServlet {
    private FavoriteService service = new FavoriteServiceImpl();
    /**
     * 分页查询
     * @param request
     * @param response
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        //1. 接收参数
        String currentPageString = request.getParameter("currentPage");
        String pageSizeString = request.getParameter("pageSize");
        String uidString = request.getParameter("uid");


        //2. 处理参数，分别是uid，当前页数，页码
        //当前用户的id
        int uid = 0;
        if(uidString != null && uidString.length() > 0){
            uid = Integer.parseInt(uidString);
        }else{
            uid = 0;
        }

        //当前页
        int currentPage = 0;
        if(currentPageString != null && currentPageString.length() > 0){
            currentPage = Integer.parseInt(currentPageString);
        }else{
            //默认当前页为1
            currentPage = 1;
        }

        //（每页条数）
        int pageSize = 0;
        if(pageSizeString != null && pageSizeString.length() > 0){
            pageSize = Integer.parseInt(pageSizeString);
        }else{
            //默认每页显示5条数据
            pageSize = 5;
        }

        //3. 调用service，检索数据
        PageBean<MyFavorite> myFavoritePageBean = service.pageQuery(uid, currentPage, pageSize);

        //JSON传值给前端
        writeValue(myFavoritePageBean,request,response);
    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws IOException
     */
    public void pageQueryOfRank(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        //1. 接收参数
        String currentPageString = request.getParameter("currentPage");
        String pageSizeString = request.getParameter("pageSize");
        String rnameString = request.getParameter("rname");
        String gt_priceString = request.getParameter("gt_price");
        String lt_priceString = request.getParameter("lt_price");

        //2. 处理参数
        double gt_price = 0.0;
        if(gt_priceString != null && gt_priceString.length() > 0){
            gt_price = Double.parseDouble(gt_priceString);
            System.out.println(gt_price);
        }

        double lt_price = 0.0;
        if(lt_priceString != null && lt_priceString.length() > 0){
            lt_price = Double.parseDouble(lt_priceString);
        }

        //当前页
        int currentPage = 0;
        if(currentPageString != null && currentPageString.length() > 0){
            currentPage = Integer.parseInt(currentPageString);
        }else{
            //默认当前页为1
            currentPage = 1;
        }

        //（每页条数）
        int pageSize = 0;
        if(pageSizeString != null && pageSizeString.length() > 0){
            pageSize = Integer.parseInt(pageSizeString);
        }

        //3. 调用service，检索数据

        PageBean<MyFavorite> favoritePageBean = service.pageQuery(rnameString, gt_price, lt_price,currentPage, pageSize);
        //JSON传值给前端
        writeValue(favoritePageBean,request,response);
    }

    /**
     * 热门推荐
     * @param request
     * @param response
     * @throws IOException
     */
    public void hotRecommend(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<MyFavorite> hot = service.hotRecommend();
        writeValue(hot, request, response);
    }

}
