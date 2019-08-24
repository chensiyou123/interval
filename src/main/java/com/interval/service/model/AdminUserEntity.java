package com.interval.service.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@TableName("admin_user")
@ApiModel("admin_user")
@Data
public class AdminUserEntity extends BaseEntity {
    @TableField(value = "account")
    @ApiModelProperty("用户账号")
    private String account;

    @TableField(value = "password")
    @ApiModelProperty("密码")
    private String password;

    @TableField(value = "nick_name")
    @ApiModelProperty("昵称")
    private String nickName;

    @TableField(value = "role_id")
    @ApiModelProperty("角色ID 0：系统管理员 1：学校管理员")
    private Integer roleId;

    @TableField(value = "school_id")
    @ApiModelProperty("所属学校ID")
    private Long schoolId;

    @TableField(value = "status")
    @ApiModelProperty("状态：0:正常 1：禁用")
    private Integer status;
}
