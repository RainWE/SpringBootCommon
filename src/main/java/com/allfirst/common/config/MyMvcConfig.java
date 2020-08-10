package com.allfirst.common.config;

import com.allfirst.common.component.LoginHandlerInterceptor;
import com.allfirst.common.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * springmvc配置
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {




    //两种写组件的方式，一种直接写在外面，一种直接放在容器里
    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            //注册页面跳转（无业务逻辑页面跳转，会被拦截器拦截）
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("news");
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //添加拦截资源和不拦截资源，addPathPatterns("/**")拦截所有,
                // excludePathPatterns("/")不拦截"/"
                //LoginHandlerInterceptor()登录拦截器
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login");
            }

        };
        return adapter;
    }

    //国际化配置
    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }


}
