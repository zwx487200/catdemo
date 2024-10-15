package com.example.catdemo.entity;

import lombok.Data;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: jennyzhuzhu
 * @date: 2024-11-18 下午7:10
 */
@Data
public class UserBill extends Billinfo  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String groupName;

    public Date startDate;

    public Date endDate;

    public List<String>   userList;



}
