package cn.xiaoyu.common.exception;

public class BizException extends RuntimeException {
    public BizException(String message) {
        super(message);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
