package com.forezp;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by forezp on 2017/4/8.
 */
@Component
public class MyFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    /*
     * 定义过滤器类型，决定该规则处理请求的哪个生命周期执行，有以下四个阶段：
     * pre: 在请求被路由之前执行
     * route : 在路由请求调用
     * post : 在route和err之后被调用
     * error：在处理请求发生错误时调用
     */
    public String filterType() {
        return "pre";
    }

    @Override
    /**
     * 过滤器执行顺序,数字越小优先级越高
     */
    public int filterOrder() {
        return 0;
    }

    @Override
    /**
     * 判断过滤器是否需要被执行
     * true 是  false  不执行
     */
    public boolean shouldFilter() {
        return false;
    }

    @Override
    /**
     * 过滤器执行的具体逻辑
     * 只有URL后面有accToken的才被允许访问
     */
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}
