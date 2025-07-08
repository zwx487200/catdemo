package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.catdemo.entity.SubjectExample;

/**
* 科目字典表 Mapper
*
* @author zhanhuibin
* @since 2025-05-07 11:56
*/
@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<Subject> selectByExample(SubjectExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    Subject selectByPrimaryKey(String id);

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
    int deleteByExample(SubjectExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(Subject record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(Subject record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(SubjectExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") Subject record, @Param("example") SubjectExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") Subject record, @Param("example") SubjectExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(Subject record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(Subject record);
}
