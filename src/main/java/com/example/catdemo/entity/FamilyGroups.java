package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 家庭群组表
 *
 * @author zhanhuibin
 * @since 2025-03-06 17:37
 */
@Data
@ApiModel("家庭群组表")
public class FamilyGroups implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("家庭主键id")
    private String id;

    @ApiModelProperty("家庭群组名字")
    private String groupName;

    @ApiModelProperty("户主")
    private String ownerId;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("更新时间")
    private Date updatedAt;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("家庭组展示图片")
    private String coverImageUrl;

    @ApiModelProperty("家庭描述")
    private String description;

    @ApiModelProperty("家庭成员列表")
    private List<FamilyMember> familyMemberList;

    @ApiModelProperty("创建人")
    private String createdBy;
}
