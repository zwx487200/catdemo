package com.example.catdemo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 家庭成员邀请码表
 *
 * @author zhanhuibin
 * @since 2025-03-10 10:25
 */
@Data
@ApiModel("家庭成员邀请码表")
public class FamilyInvites implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一邀请码（6位字母数字组合或动态长码）")
    private String inviteCode;

    @ApiModelProperty("关联家庭ID（外键 → family_groups 表）")
    private String familyGroupsId;

    @ApiModelProperty("邀请码创建者ID（户主ID，外键 → user 表）")
    private String creatorId;

    @ApiModelProperty("邀请码状态")
    private String status;

    @ApiModelProperty("过期时间（精确到秒）")
    private Date expireAt;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("绑定的用户ID（非空表示已绑定）")
    private String usedBy;

    @ApiModelProperty("HMAC签名（防篡改校验）")
    private String signature;
}
