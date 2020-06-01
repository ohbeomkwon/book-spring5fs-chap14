package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import interceptor.AuthCheckInterceptor;

@Configuration
@EnableWebMvc	// OptionalValidatorFactoryBean을 글로벌 범위 Validator로 등록
public class MvcConfig implements WebMvcConfigurer {
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("main");
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("message.label");	// message 패키지에 속한 label 파일을 불러온다는 이야기
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {	// interceptor를 추가하는 메서드. 에전에는 web.xml에서 했던 것 같음
		registry.addInterceptor(authCheckInterceptor())
							.addPathPatterns("/edit/**")		// interceptor를 수행하는 경로.
							.excludePathPatterns("/edit/help/**"); // interceptor에서 제외되는 경로.
	}
	
	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
	
}
