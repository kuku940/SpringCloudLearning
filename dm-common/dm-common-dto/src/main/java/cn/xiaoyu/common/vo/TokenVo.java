package cn.xiaoyu.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TokenVo implements Serializable {
    /**
     * 用户认证凭据
     */
    private String token;
    /**
     * 有效时长
     */
    private long expTime;
    /**
     * 生成时间
     */
    private long genTime;
}
