package com.xxx.opensys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import com.xxx.opensys.intercepter.AuthenticationIntercepter;

@Configuration
//Note: this will import DelegatingWebMvcConfiguration, which extends WebMvcConfigurationSupport
//and WebMvcConfigurationSupport will register RequestMappingHandlerMapping and RequestMappingHandlerAdapter
//thus, we do not need register RequestMappingHandlerMapping and RequestMappingHandlerAdapter
@EnableWebMvc
@ComponentScan("com.xxx.opensys")
@EnableSpringDataWebSupport
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

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthenticationIntercepter());
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("POST","PUT","DELETE","GET").allowCredentials(false).maxAge(3600);
	}
}
