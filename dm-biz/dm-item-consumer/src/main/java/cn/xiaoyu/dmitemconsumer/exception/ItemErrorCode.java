package cn.xiaoyu.dmitemconsumer.exception;

import cn.xiaoyu.common.utils.IErrorCode;

public enum ItemErrorCode implements IErrorCode {
    /**
     * 节目项目异常
     **/
    ITEM_NO_DATA("2001", "没有查询到数据"),
    IMAGE_NO_EXIST("2002", "图片不存在");
    private String errCode;
    private String errorMessage;

    ItemErrorCode(String errCode, String errorMessage) {
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
