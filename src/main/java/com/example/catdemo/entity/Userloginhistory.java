package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *
 * @author zhanhuibin
 * @since 2024-09-19 11:42
 */
@Data
@ApiModel("")
public class Userloginhistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private String userloginhistory;

    @ApiModelProperty("用户id")
    private String userid;

    @ApiModelProperty("登入时间")
    private Date loginintime;

    @ApiModelProperty("登出时间")
    private Date loginouttime;

    @ApiModelProperty("登入ip")
    private String loginip;
}
