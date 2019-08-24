package com.interval.service.controller;

import com.interval.service.annotation.SysTimeLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/login")
@Slf4j
@SysTimeLog
public class LoginController {
    @GetMapping("/toLogin")
    public Object test(){
        return "login";
    }
}
