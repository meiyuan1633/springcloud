package com.tina.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.tina.cloud_model.vo.R;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyZuulFilter extends ZuulFilter {
    /**
     * 1.过滤器类型 取值如下：
     * PRE 预处理 前置过滤器
     * ROUTING 处理中 正在执行
     * POST  请求结束 后置过滤
     * ERROR 错误过滤 一般用于收集错误信息
     * */
    @Override
    public String filterType() {
        return "pre";
    }

    /*
    * 过滤器排序 值越小 排序越靠前
    * */
    @Override
    public int filterOrder() {
        return 1;
    }

    /*
    * 是否启用当前过滤器
    * */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /*
    * 过滤器 决定什么样进行拦截
    * */

    @Override
    public Object run() throws ZuulException {
        System.out.println("过滤");
        /*
        * 要求请求的地址必须携带version参数，不携带就拦截
        *
        * */
        //1获取请求的上下文对象
        RequestContext requestContext=RequestContext.getCurrentContext();
        //2.获取当前的请求对象
        HttpServletRequest request=requestContext.getRequest();
        if (!request.getParameterMap().containsKey("version")){
            //拦截本次请求，返回错误信息
            requestContext.setResponseStatusCode(400);
            requestContext.setSendZuulResponse(false);
            HttpServletResponse response=requestContext.getResponse();
            response.setContentType("application/json;charset=UTF-8");

            try {
                response.getWriter().println(JSON.toJSON(R.fail("必须携带version")));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
