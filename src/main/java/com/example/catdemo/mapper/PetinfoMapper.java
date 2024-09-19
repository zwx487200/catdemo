package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.catdemo.entity.Petinfo;

/**
*  Mapper
*
* @author zhanhuibin
* @since 2024-09-19 11:42
*/
@Mapper
public interface PetinfoMapper {

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    Petinfo selectByPrimaryKey(String id);

    /**
     * 根据主键删除数据
     *
     * @param id
     * @return 数量
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(Petinfo record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(Petinfo record);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(Petinfo record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(Petinfo record);
}
