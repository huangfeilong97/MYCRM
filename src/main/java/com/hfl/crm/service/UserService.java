package com.hfl.crm.service;

import com.hfl.crm.entity.User;
import com.hfl.crm.exception.LoginException;


public interface UserService {

    User login(String loginAct, String loginPwd,String ip) throws LoginException;

}
