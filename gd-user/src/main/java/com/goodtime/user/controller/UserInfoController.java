package com.goodtime.user.controller;

import com.github.goodtime.service.UserInfoService;
import com.goodtime.user.service.UserService;
import com.kode.api.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制Controller类
 * Created by zhongcy on 2016/5/11.
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private DemoService demoService;

    @RequestMapping("test")
    public void test() {
        demoService.say();
        userInfoService.userRegister();
        userInfoService.userRegister();
    }

    @RequestMapping("userRegister")
    public String register(){
        return "userRegister";
    }
}