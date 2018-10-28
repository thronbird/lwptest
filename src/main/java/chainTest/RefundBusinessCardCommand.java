package com.zszq.chain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import lombok.extern.slf4j.Slf4j;

/**
 * @author  huangxiong
 * @create  2018-09-12
 *
 */

/**
 * 退商旅卡Cash
 * Created by 一代天骄 on 2018/7/1.
 */
//@Slf4j
public class RefundBusinessCardCommand implements Command{
    public boolean execute(Context context) throws Exception {
        com.zszq.chain.RefundContext refundContext = (com.zszq.chain.RefundContext) context;
        // log.info("orderId:{} 退款开始,第一步：退商旅卡，金额：{}",refundContext.getOrderId(),"10");
        System.out.println("orderId:{"+refundContext.getOrderId()+"} "+"退款开始,第一步：退商旅卡，金额：{10}");
        return false;
    }
}