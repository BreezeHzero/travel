package com.hy.travel.mapper;

import com.hy.travel.dao.CategoryDao;
import com.hy.travel.model.Category;
import com.hy.travel.service.CategoryService;
import org.junit.Test;

import java.util.List;

/**
 * Title:com.hy.travel.mapper
 * Description: 描述【
 * <p>
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/1/14 14:11
 */
public class CategoryTest {
    private CategoryDao dao = new CategoryDao();
    @Test
    public void test(){

        List<Category> all = dao.findAll();
        for (Category category : all) {
            System.out.println(category.getCid() + " " + category.getCname());
        }
    }

    @Test
    public void test2(){
        Category categoryByCid = dao.findCategoryByCid(5);
        System.out.println(categoryByCid.getCname());
    }
}
