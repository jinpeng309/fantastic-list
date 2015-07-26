package fantasticlist.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AccessTokenInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String atoken = request.getParameter("atoken");
		System.out.println("get atoken " + atoken);
		if (atoken == null || atoken.length() == 0) {
			return false;
		}
		return super.preHandle(request, response, handler);
	}
	
}
