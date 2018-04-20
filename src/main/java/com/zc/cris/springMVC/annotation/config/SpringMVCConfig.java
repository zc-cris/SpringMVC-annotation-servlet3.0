package com.zc.cris.springMVC.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zc.cris.springMVC.annotation.interceptor.MyInterceptor;

@ComponentScan(value = { "com.zc.cris.springMVC.annotation" }, includeFilters = {
        @Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) }, useDefaultFilters = false)
@EnableWebMvc       // 开启springMVC 配置功能:<mvc:annotation-driven/>
public class SpringMVCConfig extends WebMvcConfigurerAdapter {

    // 定制

    // 视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
     // 默认所有的页面都从 /WEB-INF/XXX.JSP
//        registry.jsp();
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
    
    // 静态资源访问
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    // 注册自定义的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");    // 任意多层路径的请求
    }

}
