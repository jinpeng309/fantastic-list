package fantasticlist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import fantasticlist.domain.User;

public interface UserMapper {
	@Select("select * from User where username=#{username}")
	public User getUserByUserName(String username);
	
	@Insert("insert into User (username, password) values(#{username},#{password})")
	@Options(useGeneratedKeys=true,keyProperty="uid")
	public Long insertUser(User user);
}
