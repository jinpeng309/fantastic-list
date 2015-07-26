package fantasticlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import fantasticlist.domain.User;
import fantasticlist.interceptors.AccessTokenInterceptor;

@SpringBootApplication
public class Application extends WebMvcAutoConfigurationAdapter{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AccessTokenInterceptor()).addPathPatterns("/user/**");
	}
}
