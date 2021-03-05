package com.hfl.crm.service;

import com.hfl.crm.entity.User;
import com.hfl.crm.exception.LoginException;

import java.util.List;


public interface UserService {

    User login(String loginAct, String loginPwd,String ip) throws LoginException;

    List<User> getUserList();

}
