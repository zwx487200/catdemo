package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.Babynoteinfo;
import com.example.catdemo.entity.BabynoteinfoExample;

/**
* 宝宝记 Mapper
*
* @author zhanhuibin
* @since 2024-12-04 16:54
*/
@Mapper
public interface BabynoteinfoMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<Babynoteinfo> selectByExample(BabynoteinfoExample example);

    /**
     * 根据主键id查询
     *
     * @param babynoteid
     * @return 记录信息
     */
    Babynoteinfo selectByPrimaryKey(String babynoteid);

    /**
     * 根据主键删除数据
     *
     * @param babynoteid
     * @return 数量
     */
    int deleteByPrimaryKey(String babynoteid);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(BabynoteinfoExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(Babynoteinfo record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(Babynoteinfo record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(BabynoteinfoExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") Babynoteinfo record, @Param("example") BabynoteinfoExample example);

    /**
     * 修改数据
     *
     * @param record  更新值
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("record") Babynoteinfo record, @Param("example") BabynoteinfoExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(Babynoteinfo record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(Babynoteinfo record);
}
