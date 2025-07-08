package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.PetHealthRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.catdemo.entity.PetHealthRecordExample;

/**
* 宠物健康档案表 Mapper
*
* @author zhanhuibin
* @since 2025-05-19 20:12
*/
@Mapper
public interface PetHealthRecordMapper extends BaseMapper<PetHealthRecord> {

    /**
     * 查询记录包含BLOB信息
     *
     * @param example 查询条件
     * @return 列表
     */
    List<PetHealthRecord> selectByExampleWithBLOBs(PetHealthRecordExample example);

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<PetHealthRecord> selectByExample(PetHealthRecordExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    PetHealthRecord selectByPrimaryKey(String id);

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
    int deleteByExample(PetHealthRecordExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(PetHealthRecord record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(PetHealthRecord record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(PetHealthRecordExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") PetHealthRecord record, @Param("example") PetHealthRecordExample example);

    /**
     * 更新记录包含BLOB
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleWithBLOBs(@Param("record") PetHealthRecord record, @Param("example") PetHealthRecordExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") PetHealthRecord record, @Param("example") PetHealthRecordExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(PetHealthRecord record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeyWithBLOBs(PetHealthRecord record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(PetHealthRecord record);
}
