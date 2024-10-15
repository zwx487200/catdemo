package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.MembershipPrice;
import com.example.catdemo.entity.MembershipPriceExample;

/**
* 会员价格表 Mapper
*
* @author zhanhuibin
* @since 2025-01-12 16:53
*/
@Mapper
public interface MembershipPriceMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<MembershipPrice> selectByExample(MembershipPriceExample example);

    /**
     * 根据主键id查询
     *
     * @param priceId
     * @return 记录信息
     */
    MembershipPrice selectByPrimaryKey(String priceId);

    List<MembershipPrice> selectByLevelId(String priceId);

    /**
     * 根据主键删除数据
     *
     * @param priceId
     * @return 数量
     */
    int deleteByPrimaryKey(String priceId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(MembershipPriceExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(MembershipPrice record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(MembershipPrice record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(MembershipPriceExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") MembershipPrice record, @Param("example") MembershipPriceExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") MembershipPrice record, @Param("example") MembershipPriceExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(MembershipPrice record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(MembershipPrice record);
}
