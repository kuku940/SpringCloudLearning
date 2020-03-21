package cn.xiaoyu.common.exception;

import cn.xiaoyu.common.utils.IErrorCode;

public enum ErrorCode implements IErrorCode {
    /**
     * 通用异常
     */
    COMMON_NO_LOGIN("0001", "用户未登录"),
    COMMON_EXCEPTION("0002", "系统异常"),
    /**
     * 节目项目异常
     */
    ;
    private String errCode;
    private String errorMessage;

    private ErrorCode(String errCode, String errorMessage) {
        this.errCode = errCode;
        this.errorMessage = errorMessage;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
