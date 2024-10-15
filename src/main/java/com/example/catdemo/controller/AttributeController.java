package com.example.catdemo.controller;

import com.example.catdemo.entity.Attribute;
import com.example.catdemo.service.AttributeService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 属性表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-05-10 14:50
 */
@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @PostMapping("/addAttribute")
    public Response addAttribute(@RequestBody Attribute attribute) {
        return attributeService.addAttribute(attribute);
    }

    @PostMapping("/updateAttribute")
    public Response updateAttribute(@RequestBody Attribute attribute) {
        return attributeService.updateAttribute(attribute);
    }

    @PostMapping("/deleteAttribute")
    public Response deleteAttribute(@RequestBody Attribute attribute) {
        return attributeService.deleteAttribute(attribute.getId());
    }

    @PostMapping("/getAttributeByFamilyIdAndType")
    public Response getAttributeByFamilyIdAndType(@RequestBody Attribute attribute) {
        return attributeService.getAttributeByFamilyIdAndType(attribute.getFamilyId(), attribute.getAttributeType());
    }


    @PostMapping("/getBaseAttributesByType")
    public Response getBaseAttributesByType(@RequestBody Attribute attribute) {
        return attributeService.getBaseAttributesByType(attribute.getAttributeType());
    }

    @PostMapping("/getBaseAttributeAndFamilyAttributes")
    public Response getBaseAttributeAndFamilyAttributes(@RequestBody Attribute attribute) {
        return attributeService.getBaseAttributeAndFamilyAttributes(attribute.getAttributeType(), attribute.getFamilyId());
    }

}
