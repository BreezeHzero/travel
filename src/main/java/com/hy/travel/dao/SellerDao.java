package com.hy.travel.dao;

import com.hy.travel.mapper.SellerMapper;
import com.hy.travel.model.Seller;
import com.hy.travel.util.DButil;
import org.apache.ibatis.session.SqlSession;

/**
 * Title:com.hy.travel.dao
 * Description: 描述【
 * <p>
 * 】
 * Copyright: Copyright (c) 2019
 * Company: 太原工业学院
 *
 * @author hanyang
 * @version 1.0
 * @created 2020/1/19 20:17
 */
public class SellerDao {
    public Seller findSellerBySid(int sid){
        Seller sellerBySid = null;
        SqlSession session = null;
        try {
            session = DButil.getSession();
            SellerMapper mapper = session.getMapper(SellerMapper.class);
            sellerBySid = mapper.findSellerBySid(sid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return sellerBySid;
    }
}
