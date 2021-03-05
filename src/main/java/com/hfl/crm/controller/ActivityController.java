package com.hfl.crm.controller;

import com.hfl.crm.entity.Activity;
import com.hfl.crm.entity.User;
import com.hfl.crm.service.ActivityService;
import com.hfl.crm.service.UserService;
import com.hfl.crm.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserList")
    @ResponseBody
    public List<User> getUserList(){
        List<User> userList = userService.getUserList();
        return userList;
    }

    @RequestMapping("/saveActivity")
    @ResponseBody
    public Map saveActivity(Activity activity){
        System.out.println(activity);
        activity.setId(UUIDUtil.getUUID());


        Map map=new HashMap();
        map.put("success",true);
        return map;
    }

}
