package com.hy.travel.dao;

import com.hy.travel.mapper.OrderMapper;
import com.hy.travel.mapper.SerialMapper;
import com.hy.travel.model.Serial;
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
 * @created 2020/4/25 9:38
 */
public class SerialDao {
    public boolean insertSerialOrder(String serialId, int oid, int rid, double payment, String payStype, int peoCount,int uid){
        SqlSession session = null;
        boolean flag = false;
        try {
            session = DButil.getSession();
            SerialMapper mapper = session.getMapper(SerialMapper.class);
            flag = mapper.insertSerialOrder(serialId,oid, rid,payment,payStype,peoCount,uid);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }
}
