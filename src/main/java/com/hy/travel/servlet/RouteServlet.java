package com.hy.travel.servlet;

import com.hy.travel.model.PageBean;
import com.hy.travel.model.Route;
import com.hy.travel.model.User;
import com.hy.travel.service.FavoriteService;
import com.hy.travel.service.FavoriteServiceImpl;
import com.hy.travel.service.RouteService;
import com.hy.travel.service.RouteServiceImpl;

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
 * @created 2020/1/15 14:46
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService service = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();
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
        String cidString = request.getParameter("cid");
        String rnameString = request.getParameter("rname");

        //2. 处理参数，分别是类别id，当前页数，页码
        //当前类别的id数
        int cid = 0;
        if(cidString != null && cidString.length() > 0 && !"null".equals(cidString)){
            cid = Integer.parseInt(cidString);
        }else{
            cid = 0;
        }
        System.out.println("后者+++"+cid);

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
        PageBean<Route> routePageBean = service.pageQuery(cid, currentPage, pageSize, rnameString);
        //JSON传值给前端
        writeValue(routePageBean,request,response);
    }

    /**
     * 通过rid，查询Route线路的详细信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String rid = request.getParameter("rid");

        Route one = service.findOne(Integer.parseInt(rid));
        writeValue(one,request,response);
    }

    /**
     * 判断用户是否收藏
     * @param request
     * @param response
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取线路id
        String rid = request.getParameter("rid");

        //获取登录用户信息，通过session获取
        User user = (User) request.getSession().getAttribute("user");
        //收藏时，判断用户是否登录
        int uid;
        if(user == null){
            uid = 0;
        }else{
            uid = user.getUid();
        }

        //获取到uid后，再判断该用户是否收藏过,即判断表中是否能查出收藏的线路的信息，true为收藏过，false为未收藏
        boolean flag = favoriteService.isFavorite(uid, Integer.parseInt(rid));
        writeValue(flag,request,response);
    }

    /**
     * 添加收藏
     * @param request
     * @param response
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取线路id
        String rid = request.getParameter("rid");

        //获取登录用户信息，通过session获取uid
        User user = (User) request.getSession().getAttribute("user");
        //收藏时，判断用户是否登录
        int uid;
        if(user == null){
            //用户未登录,退出程序，前端提示
            return;
        }else{
            uid = user.getUid();
        }

        //获取到uid后，进行添加，添加成功为true，失败为false
        boolean flag = favoriteService.addFavorite(uid, Integer.parseInt(rid));
        writeValue(flag,request,response);
    }

    /**
     * 取消收藏
     * @param request
     * @param response
     * @throws IOException
     */
    public void cancelFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取线路id
        String rid = request.getParameter("rid");

        //获取登录用户信息，通过session获取uid
        User user = (User) request.getSession().getAttribute("user");
        //获取用户id，此时不用判断
        int uid = user.getUid();


        //获取到uid后，进行添加，添加成功为true，失败为false
        boolean flag = favoriteService.cancelFavorite(uid, Integer.parseInt(rid));
        writeValue(flag,request,response);
    }

    /**
     * 随机推荐
     * @param request
     * @param response
     * @throws IOException
     */
    public void randomRecommend(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Route> list = service.randomRecommend();
        writeValue(list,request,response);
    }

    /**
     * 主题推荐
     * @param request
     * @param response
     * @throws IOException
     */
    public void randomSelect_theme(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Route> list = service.randomSelect_theme();
        writeValue(list,request,response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void randomCheapTravel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Route> list = service.randomCheapTravel();
        writeValue(list,request,response);
    }
}
