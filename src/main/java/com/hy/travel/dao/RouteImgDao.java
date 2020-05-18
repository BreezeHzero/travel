package com.hy.travel.dao;

import com.hy.travel.mapper.RouteImgMapper;
import com.hy.travel.model.RouteImg;
import com.hy.travel.util.DButil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

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
 * @created 2020/1/19 19:48
 */
public class RouteImgDao {
    public List<RouteImg> findByrid(int rid){
        List<RouteImg> list = new ArrayList<>();
        SqlSession session = null;
        try {
            session = DButil.getSession();
            RouteImgMapper mapper = session.getMapper(RouteImgMapper.class);
            list = mapper.findByRid(rid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return list;
    }
}
