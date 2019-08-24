package com.interval.service.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity  implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    @ApiModelProperty("修改时间")
    private Date gmtModified;

    public void preInsert(){
        this.gmtCreate = new Date();
        this.gmtModified = this.gmtCreate;
    }
    public void preUpdate(){
        this.gmtModified = new Date();
    }
}
