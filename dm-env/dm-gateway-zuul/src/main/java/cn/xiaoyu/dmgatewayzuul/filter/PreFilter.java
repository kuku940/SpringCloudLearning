package cn.xiaoyu.dmgatewayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * 前置过滤器 - 登录过滤 已关闭，详见配置文件
 * @RefreshScope 重新注入属性token
 */
@Component
@RefreshScope
public class PreFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);

    /**
     * read value from git by Config-Server
     */
    @Value("${token}")
    private boolean token;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 数值越小，优先级越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        logger.info("ReadFromConfigServer, token: {}", token);
        if (token) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
            ctx.setResponseBody("{\"msg\": \"401, access without premission, please login!\"}");
        }
        return null;
    }
}
