package com.interval.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户账户密码登录")
@Data
public class AppLoginModel {
    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("密码")
    private String password;
}
