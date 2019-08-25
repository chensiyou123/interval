package com.interval.service.controller;

import com.interval.service.annotation.SysTimeLog;
import com.interval.service.model.AppLoginModel;
import com.interval.service.service.AdminUserService;
import com.interval.service.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/web/login")
@Slf4j
@SysTimeLog
@Api(tags = "登陆控制器")
public class LoginController {

    @Autowired
    private AdminUserService adminUserService;


    @ApiOperation(value = "跳转登陆页")
    @GetMapping("/toLogin")
    public Object toLogin(){
        return "login";
    }

    @ApiOperation(value = "登陆请求")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号"),
            @ApiImplicitParam(name = "password", value = "密码")
    })
    @PostMapping("/login")
    @ResponseBody
    public R login(@RequestParam Map map, HttpServletRequest request){
        return adminUserService.login(map,request);
    }

    @ApiOperation(value = "退出登陆")
    @GetMapping("/logout")
    @ResponseBody
    public R logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("userType");
        return R.ok("退出登录成功");
    }
}
