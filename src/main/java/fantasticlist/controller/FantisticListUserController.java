package fantasticlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import fantasticlist.api.ApiCode;
import fantasticlist.api.ApiResponseBody;
import fantasticlist.domain.User;
import fantasticlist.exception.FantasticListException;
import fantasticlist.interceptors.AccessTokenInterceptor;
import fantasticlist.service.UserService;

@RestController
public class FantisticListUserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	@ResponseBody
	public ApiResponseBody getUser(@RequestParam(value="uid") long uid, @RequestParam(value="username",defaultValue="username") String userName){
		User user;
		try {
			user = userService.getUserByUserName(userName);
		} catch (FantasticListException e) {
			return ApiResponseBody.createErrorBody(ApiCode.ERR_USERNOTFOUND, e.getMessage());
		}
		return ApiResponseBody.createSuccessBody(user);
	}
	
	
}
