package com.zszq.chain;
/**
 * @author  huangxiong
 * @create  2018-09-12
 *
 */

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import lombok.extern.slf4j.Slf4j;

/**
 * 退优惠券
 * Created by 一代天骄 on 2018/7/1.
 */
@Slf4j
public class RefundPromotionCommand implements Command{


    public boolean execute(Context context) throws Exception {
        com.zszq.chain.RefundContext refundContext = (com.zszq.chain.RefundContext) context;
        // log.info("orderId:{} 退款开始,第二步：退优惠券，金额：{}",refundContext.getOrderId(),"20");
        System.out.println("orderId:{"+refundContext.getOrderId()+"}退款开始,第二步：退优惠券，金额：{5}");

        return false;
    }
}