package com.huawei.demo.mapper;

import com.huawei.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
	@Select("select * from users where id = #{id}")
	User getUserbyId(long id);

	@Insert("insert into users(name, age) values (#{name}, #{age})")
	void insert(User user);

	@Update("update users set name=#{name}, age=#{age} where id = #{id}")
	void update(User user);

	@Delete("delete from users where id = #{id}")
	void delete(Long id);

	@Select("select * from users")
	List<User> getAll();
}
