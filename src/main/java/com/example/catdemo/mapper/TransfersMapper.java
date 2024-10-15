package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.Transfers;
import com.example.catdemo.entity.TransfersExample;

/**
*  Mapper
*
* @author zhanhuibin
* @since 2024-12-10 10:44
*/
@Mapper
public interface TransfersMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<Transfers> selectByExample(TransfersExample example);

    /**
     * 根据主键id查询
     *
     * @param transferId
     * @return 记录信息
     */
    Transfers selectByPrimaryKey(String transferId);

    /**
     * 根据主键删除数据
     *
     * @param transferId
     * @return 数量
     */
    int deleteByPrimaryKey(String transferId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(TransfersExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(Transfers record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(Transfers record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(TransfersExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") Transfers record, @Param("example") TransfersExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") Transfers record, @Param("example") TransfersExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(Transfers record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(Transfers record);
}
