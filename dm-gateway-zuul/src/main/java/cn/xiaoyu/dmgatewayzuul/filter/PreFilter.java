package cn.xiaoyu.dmgatewayzuul.filter;

import com.google.common.base.Strings;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 前置过滤器 - 登录过滤 已关闭，详见配置文件
 */
@Component
public class PreFilter extends ZuulFilter {
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
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");

        if (token == null || Strings.isNullOrEmpty(token)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
            ctx.setResponseBody("{\"msg\": \"401, access without premission, please login!\"}");
        }
        return null;
    }
}
