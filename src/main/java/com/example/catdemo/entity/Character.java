package com.example.catdemo.entity;

import java.io.Serializable;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *
 * @author zhanhuibin
 * @since 2024-09-22 19:42
 */
@Data
@ApiModel("")
public class Character extends PageInfo implements Serializable  {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("人物id")
    private String characterId;

    @ApiModelProperty(" 名字")
    private String name;

    @ApiModelProperty("英文名字")
    private String nameEn;

    @ApiModelProperty("角色")
    private String role;

    @ApiModelProperty("介绍")
    private String introduction;

    @ApiModelProperty("头像")
    private String profilePicture;

    @ApiModelProperty("用户id")
    private String userId;
}
