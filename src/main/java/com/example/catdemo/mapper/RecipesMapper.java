package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.Recipes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.catdemo.entity.RecipesExample;

/**
* 家庭食谱主表 Mapper
*
* @author zhanhuibin
* @since 2025-06-03 11:15
*/
@Mapper
public interface RecipesMapper extends BaseMapper<Recipes> {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<Recipes> selectByExample(RecipesExample example);

    /**
     * 根据主键id查询
     *
     * @param recipeId
     * @return 记录信息
     */
    Recipes selectByPrimaryKey(String recipeId);

    /**
     * 根据主键删除数据
     *
     * @param recipeId
     * @return 数量
     */
    int deleteByPrimaryKey(String recipeId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(RecipesExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(Recipes record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(Recipes record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(RecipesExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") Recipes record, @Param("example") RecipesExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") Recipes record, @Param("example") RecipesExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(Recipes record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(Recipes record);
}
