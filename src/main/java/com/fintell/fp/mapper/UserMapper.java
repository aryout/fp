package com.fintell.fp.mapper;

import com.fintell.fp.vo.User;
import org.apache.ibatis.annotations.*;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 20:21 2018/10/24
 **/

@Mapper
public interface UserMapper {

    @Select("select * from t_user where t_user.name = #{username}")
    User queryUserByName(@Param(value = "username") String username);

    @Insert("insert into t_user (name) values (#{username})")
    int insertUser(@Param(value = "username") String username);

    @Delete("delete from t_user where t_user.name = #{username}")
    int deleteUser(@Param(value = "username") String username);

    @Update("update t_user set userId=#{userId},password=#{password},comment=#{comment} where userName=#{userName}")
    int updateUserByTotal(User user);

    @Update("update user set  userName=#{userName} where userId=#{userId}")
    int updateUserBySomeParam(@Param("userName")String userName,@Param("userId")String userId);
}
