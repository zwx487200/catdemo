package com.example.catdemo.mapper;

import com.example.catdemo.entity.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
    void update(Pet p);
    void delete(String id);
    Pet getById(String id);
    List<Pet> getAllByOwnId(String ownerId);
    List<Pet> listAll();
}
