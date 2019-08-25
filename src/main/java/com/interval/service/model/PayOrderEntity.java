package com.interval.service.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@TableName("pay_order")
@ApiModel("pay_order")
@Data
public class PayOrderEntity {
    @TableField(value = "order_id")
    @ApiModelProperty("随机订单ID")
    private String orderId;

    @TableField(value = "payment_type")
    @ApiModelProperty("0：开通会员 1：单独购买题集")
    private Integer paymentType;

    @TableField(value = "currency_type")
    @ApiModelProperty("货币类型 0 ：人民币 1：金币")
    private Integer currencyType;

    @TableField(value = "pay_type")
    @ApiModelProperty("支付工具类型 0：微信 1：支付宝")
    private Integer payType;

    @TableField(value = "payment_amount")
    @ApiModelProperty("支付金额")
    private BigDecimal paymentAmount;

    @TableField(value = "user_id")
    @ApiModelProperty("支付用户ID")
    private Long userId;

    @TableField(value = "status")
    @ApiModelProperty("0:预支付订单 1：支付完成 2：支付失败")
    private Integer status;

    @TableField(value = "affliate_id")
    @ApiModelProperty("")
    private Long affliateId;

    @TableField(value = "descripe")
    @ApiModelProperty("商品描述")
    private String descripe;

    @TableField(value = "transaction_id")
    @ApiModelProperty("第三方支付订单号")
    private String transactionId;
}
