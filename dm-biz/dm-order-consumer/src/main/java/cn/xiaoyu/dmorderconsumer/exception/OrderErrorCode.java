package cn.xiaoyu.dmorderconsumer.exception;

import cn.xiaoyu.common.utils.IErrorCode;

public enum OrderErrorCode implements IErrorCode {
    /**
     * 通用异常
     **/
    COMMON_NO_LOGIN("0001", "用户未登录"),
    COMMON_EXCEPTION("0002", "系统异常"),
    /**
     * 订单项目异常
     **/
    ORDER_SEAT_LOCKED("3001", "座位已被选购"),
    ORDER_NO_DATA("3002", "没有查询到数据"),
    ;
    private String errCode;
    private String errorMessage;

    OrderErrorCode(String errorCode, String errorMessage) {
        this.errCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrCode() {
        return errCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
