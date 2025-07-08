package com.example.catdemo.service;

import com.example.catdemo.entity.Attribute;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.catdemo.utils.Response;

/**
 * 属性表 服务类接口
 *
 * @author zhanhuibin
 * @since 2025-05-10 14:50
 */
public interface AttributeService extends IService<Attribute> {

    Response addAttribute(Attribute attribute);
    Response updateAttribute(Attribute attribute);
    Response deleteAttribute(String id);
    Response getAttribute(String id);
    Response getAttributeByFamilyIdAndType(String familyId, String attributeType);
    Response getBaseAttributesByType(String attributeType);
    Response getBaseAttributeAndFamilyAttributes(String attributeType, String familyId);

}
