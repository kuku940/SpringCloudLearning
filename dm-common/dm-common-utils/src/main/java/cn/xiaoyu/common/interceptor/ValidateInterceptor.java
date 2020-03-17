package cn.xiaoyu.common.interceptor;

import cn.xiaoyu.common.common.Dto;
import cn.xiaoyu.common.common.DtoUtil;
import cn.xiaoyu.common.exception.ErrorCode;
import cn.xiaoyu.common.utils.BaseException;
import cn.xiaoyu.common.utils.EmptyUtils;
import cn.xiaoyu.common.utils.LogUtils;
import cn.xiaoyu.common.utils.PrintUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateInterceptor implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(ValidateInterceptor.class);

    private String moduleName;

    private LogUtils logUtils;

    public ValidateInterceptor(String moduleName, LogUtils logUtils) {
        this.moduleName = moduleName;
        this.logUtils = logUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 异常处理
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws java.io.IOException
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        PrintUtil print = new PrintUtil(response);
        Dto dto = null;
        logger.info(request.getRequestURI() + ">>>>>>");
        //拦截异常信息
        if (EmptyUtils.isNotEmpty(ex)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
            try {
                String moduleMessage = ex.toString();
                logUtils.i(moduleName, moduleMessage);
                logUtils.i(moduleName, moduleName);
                if (ex instanceof BaseException) {
                    BaseException se = (BaseException) ex;
                    dto = DtoUtil.returnFail(se.getErrorMessage(), se.getErrorCode());
                } else {
                    dto = DtoUtil.returnFail(ErrorCode.COMMON_Exception.getErrorMessage(), ErrorCode.COMMON_Exception.getErrorCode());
                }
                String msg = JSONObject.toJSONString(dto);
                print.print(msg);
            } catch (Exception e) {
                if (!(ex instanceof BaseException)) {
                    e.printStackTrace();
                }
            }
        }
    }
}
