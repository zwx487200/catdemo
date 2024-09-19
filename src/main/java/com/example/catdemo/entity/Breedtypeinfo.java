package com.example.catdemo.entity;

import java.io.Serializable;
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
public class Breedtypeinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("宠物类型表主键id")
    private String id;

    @ApiModelProperty("宠物类型类型")
    private String breedtype;

    @ApiModelProperty("宠物类型类型二级")
    private String secondbreedtype;

    @ApiModelProperty("父级宠物类别Id")
    private String fatherbreedid;

    @ApiModelProperty("宠物类型中文名")
    private String breedtypecnname;

    @ApiModelProperty("宠物类型英文名")
    private String breedtypeenname;
}
