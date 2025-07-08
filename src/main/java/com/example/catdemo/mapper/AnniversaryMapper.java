package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.Anniversary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.catdemo.entity.AnniversaryExample;

/**
* 纪念日表 Mapper
*
* @author zhanhuibin
* @since 2025-06-24 16:41
*/
@Mapper
public interface AnniversaryMapper extends BaseMapper<Anniversary> {

    /**
     * 查询记录包含BLOB信息
     *
     * @param example 查询条件
     * @return 列表
     */
    List<Anniversary> selectByExampleWithBLOBs(AnniversaryExample example);

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<Anniversary> selectByExample(AnniversaryExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    Anniversary selectByPrimaryKey(String id);

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
    int deleteByExample(AnniversaryExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(Anniversary record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(Anniversary record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(AnniversaryExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") Anniversary record, @Param("example") AnniversaryExample example);

    /**
     * 更新记录包含BLOB
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleWithBLOBs(@Param("record") Anniversary record, @Param("example") AnniversaryExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") Anniversary record, @Param("example") AnniversaryExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(Anniversary record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeyWithBLOBs(Anniversary record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(Anniversary record);
}
