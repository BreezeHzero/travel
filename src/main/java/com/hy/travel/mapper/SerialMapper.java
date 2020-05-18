package com.hy.travel.mapper;

import org.apache.ibatis.annotations.Param;

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
 * @created 2020/4/25 9:30
 */
public interface SerialMapper {

    boolean insertSerialOrder(@Param("serialId") String serialId,
                              @Param("oid") int oid,
                              @Param("rid") int rid,
                              @Param("payment") double payment,
                              @Param("payStype") String payStype,
                              @Param("peoCount") int peoCount,
                              @Param("uid") int uid);
}
