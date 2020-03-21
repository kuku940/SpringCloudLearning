package cn.xiaoyu.common.utils;

import java.util.Map;

/**
 * 通用异常的处理
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private IErrorCode iErrorCode;
    private String errorCode;
    private String errorMessage;
    private Map<String, Object> errorData;

    public BaseException(IErrorCode iErrorCode) {
        super(iErrorCode.getErrorMessage());
        this.iErrorCode = iErrorCode;
        this.errorCode = iErrorCode.getErrCode();
        this.errorMessage = iErrorCode.getErrorMessage();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public IErrorCode getiErrorCode() {
        return iErrorCode;
    }

    public void setiErrorCode(IErrorCode iErrorCode) {
        this.iErrorCode = iErrorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Map<String, Object> getErrorData() {
        return errorData;
    }

    public void setErrorData(Map<String, Object> errorData) {
        this.errorData = errorData;
    }
}
