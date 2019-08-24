package com.interval.service.controller;

import com.interval.service.controller.annotation.SysTimeLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nlife
 * @email xiamisspan@163.com
 * @date 2019/1/17
 */
@Controller
@RequestMapping("/")
@Slf4j
@SysTimeLog
public class IndexController {
    @GetMapping("/")
    public Object index(){
        return "homePage";
    }
}
