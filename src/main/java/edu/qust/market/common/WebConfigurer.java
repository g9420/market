package edu.qust.market.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author g9420
 * @date 2019/8/31 16:40
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer{

    @Autowired
    private LimitingInterceptor limitingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(limitingInterceptor).addPathPatterns("/**");
    }
}

