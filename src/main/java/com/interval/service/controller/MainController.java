package com.interval.service.controller;

import com.interval.service.annotation.SysTimeLog;
import com.interval.service.component.LockRedisUtils;
import com.interval.service.enumeration.UserTypeEnum;
import com.interval.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @Auther: nlife
 * @Email: xiamisspan@163.com
 * @Date: 2019/1/16 0016 20:16
 * @Description:
 */
@Controller
@RequestMapping("/web/main")
@Slf4j
@SysTimeLog
public class MainController {

    @Autowired
    private LockRedisUtils lockRedisUtils;

    /**
     * 跳转到首页
     * @return
     */
    @GetMapping("/index")
    public Object index(HttpServletRequest request){
        if (UserTypeEnum.ADMIN.getValue()==Integer.valueOf(request.getSession().getAttribute("userType").toString())){

            request.setAttribute("checkUrl","index");
            //查询今日新增用户数
            int todayUser = lockRedisUtils.getNewUserCount();
            //查询今日收入
            // BigDecimal todayIncome = lockRedisUtils.getTodayIncomeCount();
            request.setAttribute("todayUser",todayUser);
            //  request.setAttribute("todayIncome",todayIncome);
            return "index";
        }else{
            request.setAttribute("checkUrl","indexNormal");
            return "indexNormal";
        }

    }
}
