package com.zszq.chain;

import org.apache.commons.chain.impl.ContextBase;

import lombok.Data;

/**
 * @author  huangxiong
 * @create  2018-09-12
 *
 */

@Data
public class RefundContext extends ContextBase {

    /**
     * 订单号
     */
    private Integer orderId;


}