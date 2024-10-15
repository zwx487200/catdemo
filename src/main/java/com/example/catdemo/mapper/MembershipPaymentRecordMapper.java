package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.MembershipPaymentRecord;
import com.example.catdemo.entity.MembershipPaymentRecordExample;

/**
* 会员支付记录表 Mapper
*
* @author zhanhuibin
* @since 2025-01-12 16:03
*/
@Mapper
public interface MembershipPaymentRecordMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<MembershipPaymentRecord> selectByExample(MembershipPaymentRecordExample example);

    /**
     * 根据主键id查询
     *
     * @param paymentId
     * @return 记录信息
     */
    MembershipPaymentRecord selectByPrimaryKey(String paymentId);

    /**
     * 根据主键删除数据
     *
     * @param paymentId
     * @return 数量
     */
    int deleteByPrimaryKey(String paymentId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(MembershipPaymentRecordExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(MembershipPaymentRecord record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(MembershipPaymentRecord record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(MembershipPaymentRecordExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") MembershipPaymentRecord record, @Param("example") MembershipPaymentRecordExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") MembershipPaymentRecord record, @Param("example") MembershipPaymentRecordExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(MembershipPaymentRecord record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(MembershipPaymentRecord record);
}
