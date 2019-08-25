package com.interval.service.controller;

import com.interval.service.annotation.SysTimeLog;
import com.interval.service.service.SchoolService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/web/school")
@Slf4j
@SysTimeLog
public class WebSchoolController {

    @Autowired
    private SchoolService schoolService;

    @ApiOperation(value = "学校管理")
    @GetMapping("/index")
    public Object index(HttpServletRequest request){
        int total = schoolService.queryTotal(null);
        request.setAttribute("total",total);
        request.setAttribute("checkUrl","schoolIndex");
        return "school/school";
    }
}
