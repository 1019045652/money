package com.an.an_be.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     * 基于URL实现的拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        PrintWriter out = null ;
//        JSONObject res = new JSONObject();
//        String path = request.getServletPath();
//        //如果未登录则验证访问地址，如果是登陆则放行，否则不予通过
//        String a =  (String)request.getSession().getAttribute("userName");
//        if(request.getSession().getAttribute("userName")==null||request.getSession().getAttribute("userName")==""){
//            if (path.matches("/login")||path.matches("/")||path.matches("/logOut")) {
//                //不需要的拦截直接过
//                return true;
//            } else {
//                res.put("code","401");
//                res.put("msg","登陆状态失效，请重新登录");
//                out = response.getWriter();
//                out.append(res.toString());
//                return false;
//            }
//        }else{
//            return true;
//        }
        return true;
    }
}
