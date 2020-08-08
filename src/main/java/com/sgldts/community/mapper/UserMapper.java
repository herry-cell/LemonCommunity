package com.sgldts.community.mapper;

import com.sgldts.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author herry
 * @create 2020-08-08-16:35
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(name, account_id, token, gmt_create, gmt_modified) " +
            "values(#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModified})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
