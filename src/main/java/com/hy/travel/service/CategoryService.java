package com.hy.travel.service;

import com.hy.travel.model.Category;

import java.util.List;

/**
 * Title:com.hy.travel.service
 * Description: 描述【
 * <p>
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/1/14 13:49
 */
public interface CategoryService {
    List<Category> findAll();

    Category findCategoryByCid(int cid);
}
