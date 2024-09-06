package com.example.catdemo.service;

import com.example.catdemo.entity.Pet;
import com.example.catdemo.utils.Response;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhanhuibin
 * @since 2024-09-05
 */
@Service
public interface IPetService  {

    Response add(Pet p);
    Response update(Pet p);
    Response delete(String id);
    Response getById(String id);
    Response getAllByOwnId(String id);
    Response listAll();


}
