package com.xxx.config;

import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import com.xxx.opensys.authentication.AuthenticationInterceptor;
import com.xxx.opensys.support.UserHandlerMethodArgumentResolver;

@Configuration
//Note: this will import DelegatingWebMvcConfiguration, which extends WebMvcConfigurationSupport
//and WebMvcConfigurationSupport will register RequestMappingHandlerMapping and RequestMappingHandlerAdapter
//thus, we do not need register RequestMappingHandlerMapping and RequestMappingHandlerAdapter
@EnableWebMvc
@ComponentScan(basePackages="com.xxx.opensys")
@EnableSpringDataWebSupport
@PropertySource(value = "classpath:resources.properties")
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(1);
		return viewResolver;
	}

	@Bean
	public ViewResolver handlebarsViewResolver() {
		HandlebarsViewResolver viewResolver = new HandlebarsViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".hbs");
		viewResolver.setOrder(0);
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/html/*.js").addResourceLocations("/WEB-INF/resources/html/");// 仅html资源在/html/下
//		registry.addResourceHandler("/js/*.js").addResourceLocations("/WEB-INF/resources/js/"); // 仅js资源在/js/下
//		registry.addResourceHandler("/js/lib/*.js").addResourceLocations("/WEB-INF/resources/js/lib/"); // 仅js资源在/js/下
//		registry.addResourceHandler("/css/*.css").addResourceLocations("/WEB-INF/resources/css/"); // 全部资源在/css/下
//		registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/resources/images/"); // 全部资源在/css/下
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public AuthenticationInterceptor authenticationInterceptor(){
		AuthenticationInterceptor authenticationInterceptor = new AuthenticationInterceptor();
		return authenticationInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authenticationInterceptor());
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("POST","PUT","DELETE","GET").allowCredentials(false).maxAge(3600);
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
			PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
			return placeholderConfigurer;
	}
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new UserHandlerMethodArgumentResolver());
	}
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		
		SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.put("com.xxx.opensys.exception.LoginException", "error/unlogin");
		simpleMappingExceptionResolver.setExceptionMappings(mappings);
		
		Properties statusCodes = new Properties();

        statusCodes.put("error/404", "404");
        statusCodes.put("error/error", "500");
        simpleMappingExceptionResolver.setStatusCodes(statusCodes);
		
		exceptionResolvers.add(simpleMappingExceptionResolver);
	}
//	@Bean
//	public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
//		
//	}
}
