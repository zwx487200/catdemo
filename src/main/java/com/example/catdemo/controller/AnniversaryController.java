package com.example.catdemo.controller;

import com.example.catdemo.entity.Anniversary;
import com.example.catdemo.entity.group.addGroup;
import com.example.catdemo.entity.group.deleteGroup;
import com.example.catdemo.entity.group.queryGroup;
import com.example.catdemo.entity.group.updateGroup;
import com.example.catdemo.service.AnniversaryService;
import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 纪念日表 前端控制器
 *
 * @author zhanhuibin
 * @since 2025-06-24 16:41
 */
@RestController
@RequestMapping("/anniversary")
public class AnniversaryController {

    @Autowired
    private AnniversaryService anniversaryService;

    @RequestMapping("/addAnniversary")
    public Response addAnniversary(@Validated(addGroup.class) @RequestBody Anniversary anniversary) {
         return anniversaryService.addAnniversary(anniversary);
    }

    @RequestMapping("/updateAnniversary")
    public Response updateAnniversary(@Validated(updateGroup.class) @RequestBody Anniversary anniversary) {
         return anniversaryService.updateAnniversary(anniversary);
    }

    @RequestMapping("/deleteAnniversary")
    public Response deleteAnniversary(@Validated(deleteGroup.class) @RequestBody Anniversary anniversary) {
         return anniversaryService.deleteAnniversary(anniversary.getId());
    }

    @RequestMapping("/getAnniversaries")
    public Response getAnniversaries(@Validated @RequestBody RequestInfo requestInfo) {
         return anniversaryService.getAnniversaries(requestInfo);
    }

    @RequestMapping("/getAnniversaryById")
    public Response getAnniversaryById(@Validated(queryGroup.class) @RequestBody Anniversary anniversary) {
         return anniversaryService.getAnniversaryById(anniversary.getId());
    }


}
