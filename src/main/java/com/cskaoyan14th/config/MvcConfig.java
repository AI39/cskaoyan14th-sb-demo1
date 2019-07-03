package com.cskaoyan14th.config;

import com.cskaoyan14th.converter.DateConverter;
import com.cskaoyan14th.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.PostConstruct;

@Configuration
//@ComponentScan(basePackages = "com.cskaoyan14th")
public class MvcConfig implements WebMvcConfigurer {

    /*视图解析器*/
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        //internalResourceViewResolver.setPrefix("/");
        //internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    /*处理器（即数据转换器）*/
    @Autowired
    ConfigurableConversionService conversionService;
    @PostConstruct
    public void addConverter(){
        //模板如下，自己添加的处理器放在后面即可
        conversionService.addConverter(new DateConverter());
        //添加的位置

    }
    @Bean
    @Primary
    public ConfigurableConversionService configurableConversionService(){
        return conversionService;
    }

    /*拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //模板如下，自己添加的拦截器放在后面即可
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/test/auth/**");
        //添加的位置

    }

    /*文件上传组件*/
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        //commonsMultipartResolver.setMaxUploadSize(1024000);                    //限制图片大小为1000k
        return commonsMultipartResolver;
    }

}