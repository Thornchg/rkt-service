package com.thornchg.rkt.controller;

import com.thornchg.rkt.entity.User;
import com.thornchg.rkt.service.UserService;
import com.thornchg.rkt.entity.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /*@PostMapping("/login")
    public ResponseEntity<? extends Object> login(@RequestBody User user,HttpSession session){
        UserVo currentUser = (UserVo) session.getAttribute("currentUser");
        System.out.println(currentUser);

        if (user.getEmail().equals("thornchg@163.com")&&user.getPassword().equals("password")){
//            return new ResponseData(200,"",null);
            UserVo userVo=new UserVo();
            userVo.setAvatar("/1.png");
            userVo.setNickName("隐辰丶");
            userVo.setEmail("Thornchg@163.com");
            userVo.setRoleName("Vip");
            session.setAttribute("currentUser",userVo);
            return new ResponseEntity<>(userVo,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }*/
    @GetMapping("/isAuthenticated")
    public ResponseEntity isAuthenticated(){
        UserVo userVo = userService.getVoByEmail("thornchg@163.com");
        return new ResponseEntity<>(userVo,HttpStatus.OK);
    }
    @RequestMapping("/loginSuccess")
    public ResponseEntity loginSuccess(){
        UserVo userVo = userService.getVoByEmail("thornchg@163.com");
        return new ResponseEntity<>(userVo,HttpStatus.OK);
    }
    @RequestMapping("/login")
    public ResponseEntity login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
//        return "/login";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON_UTF8).body(msg);
    }
    @RequestMapping("/logout")
    public ResponseEntity logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
