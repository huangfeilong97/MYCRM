package com.hfl.crm.service.Impl;

import com.hfl.crm.dao.UserDao;
import com.hfl.crm.entity.User;
import com.hfl.crm.exception.LoginException;
import com.hfl.crm.service.UserService;
import com.hfl.crm.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String loginAct, String loginPwd,String ip) throws LoginException {

        User user = userDao.selectUser(loginAct,loginPwd);

        //是否查到数据
        if(user==null){
            throw new LoginException("用户名或密码错误");
        }

        //验证是否已过失效时间
        String currentTime= DateTimeUtil.getSysTime();
        if(currentTime.compareTo(user.getExpireTime())>0){
            throw new LoginException("账户已失效");
        }

        //验证账户是否被锁定
        if("0".equals(user.getLockState())){
            throw new LoginException("账户已锁定");
        }

        String ips=user.getAllowIps();
        //判断ip地址
        if(!ips.contains(ip)){
            throw new LoginException("ip地址不允许访问");
        }

        return user;
    }
}
