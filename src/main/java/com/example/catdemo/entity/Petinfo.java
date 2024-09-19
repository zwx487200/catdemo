package com.example.catdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Petinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private String id;

    @ApiModelProperty("宠物名字")
    private String name;

    @ApiModelProperty("宠物品种")
    private String breed;

    @ApiModelProperty("宠物年纪，单位月")
    private Integer age;

    @ApiModelProperty("宠物性别，默认未知")
    private String gender;

    @ApiModelProperty("宠物的体重")
    private BigDecimal weight;

    @ApiModelProperty("是否已接种疫苗，布尔类型，默认为FALSE（未接种）")
    private Integer vaccinated;

    @ApiModelProperty("是否已绝育，默认为FALSE（未绝育）")
    private Integer neutered;

    @ApiModelProperty("绝育时间，可以为空")
    private Date neuteredtime;

    @ApiModelProperty("主人Id")
    private String ownerid;

    @ApiModelProperty("注册时间")
    private Date registrationDate;
}
