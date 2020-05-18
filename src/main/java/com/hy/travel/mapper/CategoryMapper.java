package com.hy.travel.mapper;

import com.hy.travel.model.Category;

import java.util.List;

/**
 * Title:com.hy.travel.mapper
 * Description: 描述【
 * <p>
 *     分类表的映射
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/1/14 13:42
 */
public interface CategoryMapper {
    /**
     * 查询Category全部信息
     * @return
     */
    List<Category> findAll();

    Category findCategoryByCid(int cid);

}
