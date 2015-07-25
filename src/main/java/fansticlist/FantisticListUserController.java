package fansticlist;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import fansticlist.interceptors.AccessTokenInterceptor;
import fansticlist.user.User;

@RestController
public class FantisticListUserController {
	
	@RequestMapping("/user")
	@ResponseBody
	public User getUser(@RequestParam(value="uid") long uid, @RequestParam(value="nickname",defaultValue="hahaha") String nickName){
		User user = new User(uid, "test"+uid, uid+"@test.com", nickName);
		return user;
	}
	
	
}
