package com.example.catdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.catdemo.entity.User;
import com.example.catdemo.entity.UserExample;
import org.apache.ibatis.annotations.Select;

/**
*  Mapper
*
* @author zhanhuibin
* @since 2024-12-10 19:58
*/
@Mapper
public interface UserMapper {

    /**
     * 列表查询
     *
     * @param example 条件
     * @return 列表
     */
    List<User> selectByExample(UserExample example);

    /**
     * 根据主键id查询
     *
     * @param userid
     * @return 记录信息
     */
    User selectByPrimaryKey(String userid);

    /**
     * 根据主键删除数据
     *
     * @param userid
     * @return 数量
     */
    int deleteByPrimaryKey(String userid);

    /**
     * 删除数据
     *
     * @param example 条件
     * @return 删除数量
     */
    int deleteByExample(UserExample example);

    /**
     * 插入数据库记录（不建议使用）
     *
     * @param record
     */
    int insert(User record);

    /**
     * 插入数据库记录（建议使用）
     *
     * @param record 插入数据
     * @return 插入数量
     */
    int insertSelective(User record);

    /**
     * 计数
     *
     * @param example 条件
     * @return 数量
     */
    long countByExample(UserExample example);

    /**
     * 修改数据
     *
     * @param example 条件
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("example") UserExample example);

    /**
     * 修改数据
     *
     * @param example 条件
     * @return 更新数量
     */
    int updateByExample(@Param("example") UserExample example);

    /**
     * 修改数据(推荐使用)
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新值
     * @return 更新数量
     */
    int updateByPrimaryKey(User record);

    @Select("SELECT * FROM user WHERE phone = #{phone}")
    User getUserByPhone(String phone);

    @Select("Select count(*) from User where username = #{username}" )
    int getCountbyUser(String username);

    @Select("Select * from User where username = #{username}" )
    User getUserDetailsByUsername(String username);
}
