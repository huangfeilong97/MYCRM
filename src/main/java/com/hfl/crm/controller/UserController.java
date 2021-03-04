package com.hfl.crm.controller;

import com.hfl.crm.entity.User;
import com.hfl.crm.exception.LoginException;
import com.hfl.crm.service.UserService;
import com.hfl.crm.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/login")
    @ResponseBody
    public Map login(String loginAct, String loginPwd, HttpServletRequest request) {
        //获取请求对象ip
        String ip=request.getRemoteAddr();

        //密码转换为密文
        String pwd=MD5Util.getMD5(loginPwd);

        User user= null;
        Map map=new HashMap();
        user = service.login(loginAct,pwd,ip);//可能抛出异常
        //如果程序执行到此处，说明业务层没有为controller抛出任何的异常
        //表示登录成功
        request.getSession().setAttribute("user",user);
        map.put("success",true);

        return map;





    }
}
