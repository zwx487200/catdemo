package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.Pocketbank;
import com.example.catdemo.entity.PocketbankExample;

/**
*  Mapper
*
* @author zhanhuibin
* @since 2024-12-09 15:12
*/
@Mapper
public interface PocketbankMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<Pocketbank> selectByExample(PocketbankExample example);

    /**
     * 根据主键id查询
     *
     * @param pocketBankId
     * @return 记录信息
     */
    Pocketbank selectByPrimaryKey(String pocketBankId);

    /**
     * 根据主键删除数据
     *
     * @param pocketBankId
     * @return 数量
     */
    int deleteByPrimaryKey(String pocketBankId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(PocketbankExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(Pocketbank record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(Pocketbank record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(PocketbankExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") Pocketbank record, @Param("example") PocketbankExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") Pocketbank record, @Param("example") PocketbankExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(Pocketbank record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(Pocketbank record);
}
