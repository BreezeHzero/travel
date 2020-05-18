package com.hy.travel.service;


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
 * @created 2020/4/25 9:40
 */
public interface SerialService {
    boolean insertSerialOrder(String serialId, int oid, int rid, double payment, String payStype, int peoCount,int uid);
}
