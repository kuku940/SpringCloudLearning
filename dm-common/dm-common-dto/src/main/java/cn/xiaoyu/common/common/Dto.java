package cn.xiaoyu.common.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据传输对象（后端输出对象）
 */
@Data
public class Dto<T> implements Serializable {
    /**
     * 判断系统是否出错做出相应的true或者false的返回，与业务无关，出现的各种异常
     */
    private String success;
    /**
     * 该错误码为自定义，一般0表示无错
     */
    private String errorCode;
    /**
     * 对应的提示信息
     */
    private String msg;
    /**
     * 具体返回数据内容(pojo、自定义VO、其他)
     */
    private T data;
}