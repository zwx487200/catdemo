package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.catdemo.entity.Character;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
*  Mapper
*
* @author zhanhuibin
* @since 2024-09-22 19:42
*/
@Mapper
public interface CharacterMapper {

    /**
     * 根据主键id查询
     *
     * @return 记录信息
     */
    Character selectById(@Param("id")String id);

    /**
     * 查询集合
     *
     * @return 记录信息
     */
    List<Character> selectByCharacter(Character character);

    /**
     * 根据主键删除数据
     *
     * @return 数量
     */
    int deleteById(String characterId);

    /**
     * 插入数据库记录（不建议使用）
     *
     */
    int insert(Character record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(Character record);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByIdSelective(Character record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByIdWithBLOBs(Character record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateById(Character record);
}
