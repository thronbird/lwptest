package com.zszq.chain;
/**
 * @author  huangxiong
 * @create  2018-09-12
 *
 */

import org.apache.commons.chain.impl.ChainBase;

/**
 *
 * 退票的工作流实现
 * Created by  一代天骄 on 2018/7/1.
 */
public class RefundTicketChain extends ChainBase {

    public void init() {
        //退商旅卡
        this.addCommand(new com.zszq.chain.RefundBusinessCardCommand());
        //退现金
        this.addCommand(new com.zszq.chain.RefundCashCommand());
        //退优惠券
        this.addCommand(new com.zszq.chain.RefundPromotionCommand());
    }


    public static void main(String[] args) throws Exception {
        RefundTicketChain refundTicketChain = new RefundTicketChain();
        refundTicketChain.init();
        com.zszq.chain.RefundContext context = new com.zszq.chain.RefundContext();
        context.setOrderId(1621940242);
        refundTicketChain.execute(context);
    }
}