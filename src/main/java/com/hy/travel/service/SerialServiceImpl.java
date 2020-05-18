package com.hy.travel.service;

import com.hy.travel.dao.SerialDao;

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
 * @created 2020/4/25 9:41
 */
public class SerialServiceImpl implements SerialService {
    private SerialDao dao = new SerialDao();

    @Override
    public boolean insertSerialOrder(String serialId, int oid, int rid, double payment, String payStype, int peoCount,int uid) {

        return dao.insertSerialOrder(serialId,oid, rid,payment,payStype,peoCount,uid);
    }
}
