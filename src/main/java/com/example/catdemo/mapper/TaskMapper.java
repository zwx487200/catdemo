package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.Task;
import com.example.catdemo.entity.TaskExample;

/**
*  Mapper
*
* @author zhanhuibin
* @since 2024-12-05 19:37
*/
@Mapper
public interface TaskMapper {

    /**
     * 查询记录包含BLOB信息
     *
     * @param example 查询条件
     * @return 列表
     */
    List<Task> selectByExampleWithBLOBs(TaskExample example);

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<Task> selectByExample(TaskExample example);

    /**
     * 根据主键id查询
     *
     * @param taskId
     * @return 记录信息
     */
    Task selectByPrimaryKey(String taskId);

    /**
     * 根据主键删除数据
     *
     * @param taskId
     * @return 数量
     */
    int deleteByPrimaryKey(String taskId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(TaskExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(Task record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(Task record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(TaskExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     * 更新记录包含BLOB
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleWithBLOBs(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(Task record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeyWithBLOBs(Task record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(Task record);
}
