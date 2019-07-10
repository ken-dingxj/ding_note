package com.dingjin.ding_note.Interceptor;


import com.dingjin.ding_note.annotation.CheckSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    private static Logger LOG = LoggerFactory.getLogger(MyInterceptor.class);

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
      System.out.println("进入preHandle.....");
        if (!(handler instanceof HandlerMethod)) {
            LOG.warn("UnSupport handler");
            throw new IllegalArgumentException("Interceptor only supports HandlerMethod handler");
        }
        //拿到请求参数里面的source参数
        String source = httpServletRequest.getParameter("source");
        String errorMsg = null;
        //如果source为空,返回错误
        if (null == source || "".equals(source)) {
            errorMsg = "No source in params";
        }
        if (errorMsg != null) {
            httpServletResponse.setStatus(500);
            LOG.info(errorMsg);
            httpServletResponse.getWriter().write(errorMsg);
            return false;
        }
        //拿到该方法上的注解对象
        CheckSource checkSource = getCheckSource((HandlerMethod) handler);
        if(checkSource !=null){
            String[] sources=checkSource.sources();
            if(sources.length==0||sources[0].equals("all")){
                //列表为空或者为默认值,放行
                return true;
            }
            //遍历列表,如果传入的参数在其中,则放行
            for (String s : sources) {
                if (s.equals(source)) {
                    return true;
                }
            }
            //如果传入的source参数不再允许的参数列表中，则拦截请求，并返回错误信息
            errorMsg = "source is not support";
            httpServletResponse.getWriter().write(errorMsg);
            return false;
        }
        return true;

    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("进入postHandle.....");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("进入afterCompletion.....");
    }
    /**
     * 拿到该方法上的checksource注解对象
     */
    private CheckSource getCheckSource(HandlerMethod handlerMethod){
        if (handlerMethod.getBeanType().isAnnotationPresent(CheckSource.class)) {
            return handlerMethod.getBeanType().getAnnotation(CheckSource.class);
        } else if (handlerMethod.getMethod().isAnnotationPresent(CheckSource.class)) {
            return handlerMethod.getMethod().getAnnotation(CheckSource.class);
        }
        return null;
    }
}
