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
 * @since 2024-12-25 19:22
 */
@Data
@ApiModel("")
public class FamilyMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private String memberId;

    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("生日")
    private Date birthDate;

    @ApiModelProperty("年纪")
    private Integer age;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("学历")
    private String education;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("关系")
    private String relationship;

    @ApiModelProperty("角色")
    private String role;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("家庭组id")
    private String familyGroupsId;

    @ApiModelProperty("")
    private String notes;

    @ApiModelProperty("是否同步创建用户，0-不同步，1-同步")
    private String isSyncCreateUser;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String passWord;
}
