package com.hy.travel.servlet;

import com.hy.travel.model.Category;
import com.hy.travel.service.CategoryService;
import com.hy.travel.service.CategoryServiceImpl;

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
 * @created 2020/1/14 13:53
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService service = new CategoryServiceImpl();
    /**
     * 查找全部信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Category> all = service.findAll();
        writeValue(all,request,response);
    }

    /**
     * 根据cid查询类别，异步获取上一步信息，rname名称和详细信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void findCategoryByCid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cidString = request.getParameter("cid");

        Category category = service.findCategoryByCid(Integer.parseInt(cidString));

        writeValue(category,request,response);
    }
}
