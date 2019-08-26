package com.tensquare.qa.config;

import com.tensquare.qa.interceptor.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration //这个配置文件 ！！！！！！！！！不要忘记
public class InterceptorConfig extends WebMvcConfigurationSupport {

    //主要是代码springmvc配置文件使拦截器生效

    @Autowired
    private JwtFilter jwtFilter;

    //添加拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器要声明拦截器对象和要拦截的请求
        System.out.println("添加拦截器");
        registry.addInterceptor(jwtFilter).
                addPathPatterns("/**")  //拦截所有
                .excludePathPatterns("/**/login");  //放行登录页面
    }

}

