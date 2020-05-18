package com.hy.travel.dao;

import com.hy.travel.mapper.RouteMapper;
import com.hy.travel.model.Route;
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
 * @created 2020/1/15 16:13
 */
public class RouteDao {
    /**
     * 总记录数
     * @param cid
     * @return
     */
    public int getTotalCount(int cid,String rname){
        int totalCount = 0;
        SqlSession session = null;
        try {
            session = DButil.getSession();
            RouteMapper mapper = session.getMapper(RouteMapper.class);
            totalCount = mapper.getTotalCount(cid,rname);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return totalCount;
    }

    /**
     * 查询出每页的数据
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize,String rname){
        List<Route> list = new ArrayList<>();
        SqlSession session = null;
        try {
            session = DButil.getSession();
            RouteMapper mapper = session.getMapper(RouteMapper.class);
            list = mapper.findByPage(cid, start, pageSize,rname);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return list;
    }

    /**
     * 根据rid查询Route
     * @param rid
     * @return
     */
    public Route findOne(int rid){
        Route one = null;
        SqlSession session = null;
        try {
            session = DButil.getSession();
            RouteMapper mapper = session.getMapper(RouteMapper.class);
            one = mapper.findOne(rid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return one;
    }

    /**
     * 根据rid查询被收藏次数
     * @param rid 路线id
     * @return
     */
    public int findCountByRid(int rid){
        SqlSession session = null;
        int count = 0;
        try {
            session = DButil.getSession();
            RouteMapper mapper = session.getMapper(RouteMapper.class);
            count = mapper.findCountByRid(rid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return count;
    }

    /**
     * 随机推荐
     * @return
     */
    public List<Route> randomSelect(){
        SqlSession session = null;
        List<Route> list = new ArrayList<>();
        try {
            session = DButil.getSession();
            RouteMapper mapper = session.getMapper(RouteMapper.class);
            list = mapper.randomSelect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return list;
    }

    /**
     * 主题旅游
     * @return
     */
    public List<Route> randomSelect_theme(){
        SqlSession session = null;
        List<Route> list = new ArrayList<>();
        try {
            session = DButil.getSession();
            RouteMapper mapper = session.getMapper(RouteMapper.class);
            list = mapper.randomSelect_theme();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return list;
    }

    /**
     * 特价游
     * @return
     */
    public List<Route> randomCheapTravel(){
        SqlSession session = null;
        List<Route> list = new ArrayList<>();
        try {
            session = DButil.getSession();
            RouteMapper mapper = session.getMapper(RouteMapper.class);
            list = mapper.randomCheapTravel();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeSession(session);
        }
        return list;
    }
}
