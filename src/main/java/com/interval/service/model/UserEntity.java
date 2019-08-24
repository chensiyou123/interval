package com.interval.service.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@TableName("user")
@ApiModel("user")
@Data
public class UserEntity extends BaseEntity {
    @TableField(value = "account")
    @ApiModelProperty("账号")
    private String account;

    @TableField(value = "password")
    @ApiModelProperty("密码")
    private String password;

    @TableField(value = "phone")
    @ApiModelProperty("手机号码")
    private String phone;

    @TableField(value = "nick_name")
    @ApiModelProperty("昵称")
    private String nickName;

    @TableField(value = "birthday")
    @ApiModelProperty("生日")
    private String birthday;

    @TableField(value = "img_url")
    @ApiModelProperty("头像")
    private String imgUrl;

    @TableField(value = "sex")
    @ApiModelProperty("0:  未设置 1：男 2：女")
    private Integer sex;

    @TableField(value = "role_id")
    @ApiModelProperty("0：普通会员 1：付费会员")
    private Integer roleId;

    @TableField(value = "status")
    @ApiModelProperty("0：未选择课程1：启用 2：禁用")
    private Integer status;

    @TableField(value = "school_id")
    @ApiModelProperty("所属学校ID")
    private Long schoolId;

    @TableField(value = "vip_start_time")
    @ApiModelProperty("会员开始时间")
    private String vipStartTime;

    @TableField(value = "vip_end_time")
    @ApiModelProperty("会员结束时间")
    private String vipEndTime;

    @TableField(value = "qq_open_id")
    @ApiModelProperty("qq开发平台对应id")
    private String qqOpenId;

    @TableField(value = "weixin_opne_id")
    @ApiModelProperty("微信开放平台对应id")
    private String weixinOpneId;
}
