package fantasticlist.service;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import fantasticlist.domain.User;
import fantasticlist.exception.ErrorCode;
import fantasticlist.exception.FantasticListException;
import fantasticlist.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper; 
	
	public User getUserByUserName(String  userName) throws FantasticListException{
		User user = userMapper.getUserByUserName(userName);
		if (user == null) {
			throw new FantasticListException("没有该用户", ErrorCode.A00002);
		}
		return user;
	}
	
	public User insertUser(User user) throws FantasticListException{
		try {
			Long uid = userMapper.insertUser(user);
			user.setUid(uid);
		} catch (DuplicateKeyException e) {
			throw new FantasticListException("inser user error", ErrorCode.A00001);
		}
		return user;
	}

}
