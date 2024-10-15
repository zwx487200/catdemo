package com.example.catdemo.mapper;

import com.example.catdemo.entity.FamilyMemberExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.FamilyMember;

/**
*  Mapper
*
* @author zhanhuibin
* @since 2024-12-25 19:22
*/
@Mapper
public interface FamilyMemberMapper {

    /**
     * 查询记录包含BLOB信息
     *
     * @param example 查询条件
     * @return 列表
     */
    List<FamilyMember> selectByExampleWithBLOBs(FamilyMemberExample example);

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<FamilyMember> selectByExample(FamilyMemberExample example);

    /**
     * 根据主键id查询
     *
     * @param memberId
     * @return 记录信息
     */
    FamilyMember selectByPrimaryKey(String memberId);

    /**
     * 根据主键删除数据
     *
     * @param memberId
     * @return 数量
     */
    int deleteByPrimaryKey(String memberId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(FamilyMemberExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(FamilyMember record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(FamilyMember record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(FamilyMemberExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") FamilyMember record, @Param("example") FamilyMemberExample example);

    /**
     * 更新记录包含BLOB
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleWithBLOBs(@Param("record") FamilyMember record, @Param("example") FamilyMemberExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") FamilyMember record, @Param("example") FamilyMemberExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(FamilyMember record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeyWithBLOBs(FamilyMember record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(FamilyMember record);
}
