package com.example.catdemo.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 宝宝记
 *
 * @author zhanhuibin
 * @since 2024-12-04 16:54
 */
@Data
@ApiModel("宝宝记")
public class Babynoteinfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键Id")
    private String babynoteid;

    @ApiModelProperty("用户id")
    private String userid;

    @ApiModelProperty("宝宝记类型（01喝奶、02吃饭、03睡觉、04换纸尿布、05洗澡、99其他）")
    private String babynotetype;

    @ApiModelProperty("宝宝记日期")
    private Date babynotedate;

    @ApiModelProperty("宝宝记时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date babynotestarttime;

    @ApiModelProperty("宝宝记结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date babynoteendtime;

    @ApiModelProperty("宝宝记内容（奶量/睡眠时间/）")
    private String babynotecontent;

    @ApiModelProperty("宝宝记状态")
    private String babynotestatus;

    @ApiModelProperty("宝宝记备注")
    private Integer babynoteremark;

    @ApiModelProperty("宝宝Id")
    private String babyid;
}
