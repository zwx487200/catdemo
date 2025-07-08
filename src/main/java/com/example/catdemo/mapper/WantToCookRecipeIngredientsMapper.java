package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.WantToCookRecipeIngredients;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.catdemo.entity.WantToCookRecipeIngredientsExample;

/**
* 想吃食谱食材关联表 Mapper
*
* @author zhanhuibin
* @since 2025-06-09 11:48
*/
@Mapper
public interface WantToCookRecipeIngredientsMapper extends BaseMapper<WantToCookRecipeIngredients> {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<WantToCookRecipeIngredients> selectByExample(WantToCookRecipeIngredientsExample example);

    /**
     * 根据主键id查询
     *
     * @param id
     * @return 记录信息
     */
    WantToCookRecipeIngredients selectByPrimaryKey(String id);

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
    int deleteByExample(WantToCookRecipeIngredientsExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(WantToCookRecipeIngredients record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(WantToCookRecipeIngredients record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(WantToCookRecipeIngredientsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") WantToCookRecipeIngredients record, @Param("example") WantToCookRecipeIngredientsExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") WantToCookRecipeIngredients record, @Param("example") WantToCookRecipeIngredientsExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(WantToCookRecipeIngredients record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(WantToCookRecipeIngredients record);
}
