package com.an.an_be.controller;

import com.an.an_be.entity.Result;
import com.an.an_be.entity.User;
import com.an.an_be.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@CrossOrigin(maxAge = 3600,allowCredentials = "true")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        Subject currentUser = SecurityUtils.getSubject();
        Result result = new Result();
        try {
            //主体提交登录请求到SecurityManager
            currentUser.login(token);
        } catch (IncorrectCredentialsException ice) {
            return new Result(403, "密码不正确", true);
        } catch (UnknownAccountException uae) {
            return new Result(403, "账号不存在", true);
        } catch (AuthenticationException ae) {
            return new Result(403, "状态不正常", true);
        }
        if (currentUser.isAuthenticated()) {
            request.getSession().setAttribute("userName",user.getUserName());
            return new Result(200, "登陆成功", true);
        } else {
            token.clear();
            result.setCode(403);
            return result;
        }
    }
    @PostMapping("/logOut")
    public String logOut(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-llow-redentials","true");
        request.getSession().invalidate();
        return "200";
    }
}
