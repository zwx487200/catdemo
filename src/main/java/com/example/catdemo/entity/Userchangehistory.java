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
public class Userchangehistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private String userchangehistoryid;

    @ApiModelProperty("用户id")
    private String userid;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("角色")
    private String role;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("创建时间")
    private Date createtime;

    @ApiModelProperty("更新时间")
    private Date updatetime;
}
