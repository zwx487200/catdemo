package com.example.catdemo.service.impl;

import com.example.catdemo.entity.AttributeExample;
import com.example.catdemo.service.AttributeService;
import com.example.catdemo.entity.Attribute;
import com.example.catdemo.mapper.AttributeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.catdemo.utils.Response;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 属性表 服务实现类
 *
 * @author zhanhuibin
 * @since 2025-05-10 14:50
 */
@Service
public class AttributeServiceImpl extends ServiceImpl<AttributeMapper, Attribute> implements AttributeService {

    @Autowired
    private AttributeMapper attributeMapper;
    @Override
    public Response addAttribute(Attribute attribute) {
        if (StringUtils.isNotBlank(attribute.getFamilyId())) {
            attribute.setIsCustom(1);
        } else {
            attribute.setIsCustom(0);
        }
        attribute.setId(UUID.randomUUID().toString());
        int result = attributeMapper.insert(attribute);
        if (result > 0) {
            return Response.success(attribute);
        } else {
            return Response.error("Failed to add attribute");
        }
    }


    @Override
    public Response updateAttribute(Attribute attribute) {
        if (StringUtils.isNotBlank(attribute.getFamilyId())) {
            attribute.setIsCustom(1);
        } else {
            attribute.setIsCustom(0);
        }
        int result = attributeMapper.updateByPrimaryKey(attribute);
        if (result > 0) {
            return Response.success(attribute);
        } else {
            return Response.error("Failed to update attribute");
        }
    }

    @Override
    public Response deleteAttribute(String id) {
        return null;
    }

    @Override
    public Response getAttribute(String id) {
        return null;
    }

    @Override
    public Response getAttributeByFamilyIdAndType(String familyId, String attributeType) {
        AttributeExample example = new AttributeExample();
        AttributeExample.Criteria criteria = example.createCriteria();
        criteria.andFamilyIdEqualTo(familyId);
        criteria.andAttributeTypeEqualTo(attributeType);
        criteria.andIsCustomEqualTo(1);
        return Response.success(attributeMapper.selectByExample(example));
    }

    @Override
    public Response getBaseAttributesByType(String attributeType) {
        AttributeExample example = new AttributeExample();
        AttributeExample.Criteria criteria = example.createCriteria();
        criteria.andAttributeTypeEqualTo(attributeType);
        criteria.andIsCustomEqualTo(0);
        return Response.success(attributeMapper.selectByExample(example));
    }

    @Override
    public Response getBaseAttributeAndFamilyAttributes(String attributeType, String familyId) {

        if (StringUtils.isBlank(attributeType)) {
            return Response.error("Invalid input");
        }

        AttributeExample example = new AttributeExample();
        AttributeExample.Criteria criteria = example.createCriteria();
        criteria.andAttributeTypeEqualTo(attributeType);
        criteria.andIsCustomEqualTo(0);
        List<Attribute> baseAttributes =  attributeMapper.selectByExample(example);
        if(StringUtils.isNotBlank(familyId)){
            AttributeExample example2 = new AttributeExample();
            AttributeExample.Criteria criteria2 = example2.createCriteria();
            criteria2.andFamilyIdEqualTo(familyId);
            criteria2.andAttributeTypeEqualTo(attributeType);
            criteria2.andIsCustomEqualTo(1);
            List<Attribute> familyAttributes =  attributeMapper.selectByExample(example2);
            baseAttributes.addAll(familyAttributes);
        }
        return Response.success(baseAttributes);
    }
}
