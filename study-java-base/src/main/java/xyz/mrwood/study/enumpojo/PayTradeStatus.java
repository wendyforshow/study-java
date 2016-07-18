package xyz.mrwood.study.enumpojo;

/**
 * 项目：saledian-merchant
 * 包名：com.fshows.saledian.merchant.model.alipay
 * 功能：支付状态
 * 时间：2016-07-18 10:20
 * 作者：Mr.Kiwi
 */
public enum PayTradeStatus {

    // 交易创建，等待买家付款
    WAIT_BUYER_PAY,
    // 未付款交易超时关闭，或支付完成后全额退款
    TRADE_CLOSED,
    // 交易支付成功
    TRADE_SUCCESS,
    // 交易结束，不可退款
    TRADE_FINISHED
}
