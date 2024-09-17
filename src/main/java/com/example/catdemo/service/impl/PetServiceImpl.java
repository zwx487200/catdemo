package com.example.catdemo.service.impl;


import com.example.catdemo.entity.Pet;
import com.example.catdemo.mapper.PetMapper;
import com.example.catdemo.service.IPetService;
import com.example.catdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhanhuibin
 * @since 2024-09-05
 */
@Service
public class PetServiceImpl implements IPetService {

    @Autowired
    PetMapper petMapper;

    @Override
    public Response add(Pet p) {
        p.setId(UUID.randomUUID().toString());
        petMapper.add(p);
        Pet petInfo = petMapper.getById(p.getId());
        if (petInfo != null) {
            return Response.success(petInfo);
        } else {
            return Response.error("500", "添加宠物信息失败");
        }
    }

    @Override
    public Response update(Pet p) {
        return null;
    }

    @Override
    public Response delete(String id) {
        return null;
    }

    @Override
    public Response getById(String id) {
        return null;
    }

    @Override
    public Response getAllByOwnId(String id) {
        return null;
    }

    @Override
    public Response listAll() {
        return null;
    }
}
