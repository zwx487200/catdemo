package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.PetInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.catdemo.entity.PetInfoExample;

/**
* 宠物基本信息表 Mapper
*
* @author zhanhuibin
* @since 2025-05-14 14:56
*/
@Mapper
public interface PetInfoMapper extends BaseMapper<PetInfo> {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<PetInfo> selectByExample(PetInfoExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    PetInfo selectByPrimaryKey(String id);

    /**
     * 根据主键删除数据
     *
     * @param id
     * @return 数量
     */
    int deleteByPrimaryKey(String id);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(PetInfoExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(PetInfo record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(PetInfo record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(PetInfoExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") PetInfo record, @Param("example") PetInfoExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") PetInfo record, @Param("example") PetInfoExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(PetInfo record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(PetInfo record);
}
