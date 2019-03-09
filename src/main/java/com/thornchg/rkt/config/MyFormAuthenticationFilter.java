package com.thornchg.rkt.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.thornchg.rkt.entity.User;
import com.thornchg.rkt.entity.vo.UserVo;
import com.thornchg.rkt.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(MyFormAuthenticationFilter.class);
    public MyFormAuthenticationFilter(UserService userService){
        super();
        this.userService = userService;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletResponse res= (HttpServletResponse) response;
        res.addHeader("Access-Control-Allow-Origin","http://192.168.101.44:8081");
        res.addHeader("Access-Control-Allow-Credentials","true");
        return super.onPreHandle(request,response,mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (this.isLoginRequest(request, response)) {
            if (this.isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }

                return this.executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }

                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [" + this.getLoginUrl() + "]");
            }
            HttpServletResponse res= (HttpServletResponse) response;
            if (this.isAuthenticatedRequest(request,response)){
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("status",401);
                PrintWriter out = res.getWriter();
                out.write(jsonObject.toJSONString());
                out.flush();
                return false;
            }
//            this.saveRequestAndRedirectToLogin(request, response);
            res.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
//        return super.onAccessDenied(request, response);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse res= (HttpServletResponse) response;
//        res.setStatus(200);
        User user= (User) subject.getPrincipal();
        UserVo userVo = userService.getVoById(user.getId());
        res.addHeader("Content-Type","application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(userVo));
        out.flush();
        return false;
//        return super.onLoginSuccess(token, subject, request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        return super.onLoginFailure(token, e, request, response);
    }
    public boolean isAuthenticatedRequest(ServletRequest request, ServletResponse response){
        return this.pathsMatch("/isAuthenticated", request);

    }
}
