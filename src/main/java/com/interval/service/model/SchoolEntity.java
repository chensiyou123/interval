package com.interval.service.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 *
 * @author nlife
 * @date 2019-01-14 20:07:26
 */
@TableName("school")
@ApiModel("school")
@Data
public class SchoolEntity extends BaseEntity{

	@TableField(value = "school_name")
	@ApiModelProperty("学校名称")
	private String schoolName;

	@TableField(value = "status")
	@ApiModelProperty("0:正常 1：禁用")
	private Integer status;


}
