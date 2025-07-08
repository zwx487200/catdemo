package com.example.catdemo.mapper;

import com.example.catdemo.entity.FamilyInvites;
import com.example.catdemo.entity.FamilyInvitesExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* 家庭成员邀请码表 Mapper
*
* @author zhanhuibin
* @since 2025-03-10 09:54
*/
@Mapper
public interface FamilyInvitesMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<FamilyInvites> selectByExample(FamilyInvitesExample example);

    /**
     * 根据主键id查询
     *
     * @param inviteCode
     * @return 记录信息
     */
    FamilyInvites selectByPrimaryKey(String inviteCode);

    /**
     * 根据主键删除数据
     *
     * @param inviteCode
     * @return 数量
     */
    int deleteByPrimaryKey(String inviteCode);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(FamilyInvitesExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(FamilyInvites record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(FamilyInvites record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(FamilyInvitesExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") FamilyInvites record, @Param("example") FamilyInvitesExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") FamilyInvites record, @Param("example") FamilyInvitesExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(FamilyInvites record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(FamilyInvites record);
}
