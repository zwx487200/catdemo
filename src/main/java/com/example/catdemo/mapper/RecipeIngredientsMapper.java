package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.RecipeIngredients;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.catdemo.entity.RecipeIngredientsExample;

/**
* 食谱食材明细表 Mapper
*
* @author zhanhuibin
* @since 2025-06-03 17:31
*/
@Mapper
public interface RecipeIngredientsMapper extends BaseMapper<RecipeIngredients> {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<RecipeIngredients> selectByExample(RecipeIngredientsExample example);

    /**
     * 根据主键id查询
     *
     * @param ingredientId
     * @return 记录信息
     */
    RecipeIngredients selectByPrimaryKey(String ingredientId);

    /**
     * 根据主键删除数据
     *
     * @param ingredientId
     * @return 数量
     */
    int deleteByPrimaryKey(String ingredientId);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(RecipeIngredientsExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(RecipeIngredients record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(RecipeIngredients record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(RecipeIngredientsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") RecipeIngredients record, @Param("example") RecipeIngredientsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") RecipeIngredients record, @Param("example") RecipeIngredientsExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(RecipeIngredients record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(RecipeIngredients record);
}
