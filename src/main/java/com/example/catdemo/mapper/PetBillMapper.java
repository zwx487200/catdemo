package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.PetBill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.catdemo.entity.PetBillExample;

/**
* 宠物健康档案表 Mapper
*
* @author zhanhuibin
* @since 2025-05-19 21:36
*/
@Mapper
public interface PetBillMapper extends BaseMapper<PetBill> {

    /**
     * 查询记录包含BLOB信息
     *
     * @param example 查询条件
     * @return 列表
     */
    List<PetBill> selectByExampleWithBLOBs(PetBillExample example);

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<PetBill> selectByExample(PetBillExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    PetBill selectByPrimaryKey(String id);

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
    int deleteByExample(PetBillExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(PetBill record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(PetBill record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(PetBillExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") PetBill record, @Param("example") PetBillExample example);

    /**
     * 更新记录包含BLOB
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleWithBLOBs(@Param("record") PetBill record, @Param("example") PetBillExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") PetBill record, @Param("example") PetBillExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(PetBill record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeyWithBLOBs(PetBill record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(PetBill record);
}
