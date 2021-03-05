package com.hfl.crm.dao;

import com.hfl.crm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {


    User selectUser(@Param("loginAct") String loginAct,@Param("loginPwd") String loginPwd);

    List<User> getUserList();
}
