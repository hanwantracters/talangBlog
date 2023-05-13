package com.itheima.dao;

import com.itheima.domain.Identity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface IdentityDao
{
    @Insert("insert into identity (username,password) values(#{username},#{password})")
    public boolean save(Identity identity);
    @Select("select * from identity where username = #{username}")
    public Identity compare(Identity identity);
}
