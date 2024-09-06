package com.example.catdemo.mapper;

import com.example.catdemo.entity.Pet;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhanhuibin
 * @since 2024-09-05
 */
@Mapper
public interface PetMapper  {
    // 自定义方法示例
    void add(Pet p);
//    Response update(Pet p);
//    Response delete(String id);
//    Response getById(String id);
//    Response getAllByOwnId(String id);
//    Response listAll();

}
