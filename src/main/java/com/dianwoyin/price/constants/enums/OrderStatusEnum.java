package com.dianwoyin.price.constants.enums;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
public enum OrderStatusEnum {
    WaitPay(1, "待支付"),
    WaitDelivery(2, "待发货"),
    WaitConfirmReceipt(3, "待收货"),
    Refunded(5, "已退款"),
    Finished(4, "已完成"),
    ;

    private int code;
    private String desc;

    OrderStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
}
