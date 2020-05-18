package com.hy.travel.mapper;

import com.hy.travel.model.Seller;

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
 * @created 2020/1/19 20:06
 */
public interface SellerMapper {
    /**
     * 根绝sid查询出卖家
     * @param sid
     * @return
     */
    public Seller findSellerBySid(int sid);
}
