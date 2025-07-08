package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.Todo;
import com.example.catdemo.entity.TodoExample;

/**
* 待办事项核心表 Mapper
*
* @author zhanhuibin
* @since 2025-03-24 17:16
*/
@Mapper
public interface TodosMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<Todo> selectByExample(TodoExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    Todo selectByPrimaryKey(String id);

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
    int deleteByExample(TodoExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(Todo record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(Todo record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(TodoExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") Todo record, @Param("example") TodoExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") Todo record, @Param("example") TodoExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(Todo record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(Todo record);
}
