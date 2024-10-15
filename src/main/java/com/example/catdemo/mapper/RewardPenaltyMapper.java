package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.RewardPenalty;
import com.example.catdemo.entity.RewardPenaltyExample;

/**
*  Mapper
*
* @author zhanhuibin
* @since 2024-12-09 14:40
*/
@Mapper
public interface RewardPenaltyMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<RewardPenalty> selectByExample(RewardPenaltyExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    RewardPenalty selectByPrimaryKey(Integer id);

    /**
     * 根据主键删除数据
     *
     * @param id
     * @return 数量
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(RewardPenaltyExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(RewardPenalty record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(RewardPenalty record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(RewardPenaltyExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") RewardPenalty record, @Param("example") RewardPenaltyExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") RewardPenalty record, @Param("example") RewardPenaltyExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(RewardPenalty record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(RewardPenalty record);
}
