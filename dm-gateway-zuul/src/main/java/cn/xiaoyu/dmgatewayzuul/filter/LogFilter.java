package cn.xiaoyu.dmgatewayzuul.filter;

import cn.xiaoyu.common.utils.JacksonUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日志过滤器 未生效
 */
@Component
public class LogFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

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
        HttpServletResponse response = null;
        try {
            response = ctx.getResponse();
            return response;
        } finally {
            logger.info("request: {}, \r\n response: {}", JacksonUtils.toJson(request), JacksonUtils.toJson(response));
        }
    }
}
