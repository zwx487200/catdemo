package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.MembershipBenefit;
import com.example.catdemo.entity.MembershipBenefitExample;

/**
* 会员权益表 Mapper
*
* @author zhanhuibin
* @since 2025-01-13 11:11
*/
@Mapper
public interface MembershipBenefitMapper {

    /**
     * 查询记录包含BLOB信息
     *
     * @param example 查询条件
     * @return 列表
     */
    List<MembershipBenefit> selectByExampleWithBLOBs(MembershipBenefitExample example);

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<MembershipBenefit> selectByExample(MembershipBenefitExample example);

    /**
     * 根据主键id查询
     *
     * @param benefitId
     * @return 记录信息
     */
    MembershipBenefit selectByPrimaryKey(String benefitId);

    /**
     * 根据主键删除数据
     *
     * @param benefitId
     * @return 数量
     */
    int deleteByPrimaryKey(String benefitId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(MembershipBenefitExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(MembershipBenefit record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(MembershipBenefit record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(MembershipBenefitExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") MembershipBenefit record, @Param("example") MembershipBenefitExample example);

    /**
     * 更新记录包含BLOB
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleWithBLOBs(@Param("record") MembershipBenefit record, @Param("example") MembershipBenefitExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") MembershipBenefit record, @Param("example") MembershipBenefitExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(MembershipBenefit record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeyWithBLOBs(MembershipBenefit record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(MembershipBenefit record);
}
