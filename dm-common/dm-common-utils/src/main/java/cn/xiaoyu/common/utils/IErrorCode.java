package cn.xiaoyu.common.utils;

import java.io.Serializable;

public interface IErrorCode extends Serializable {
    String getErrCode();

    String getErrorMessage();
}
