package com.allfirst.common.config;

import com.allfirst.common.filter.MyFilter;
import com.allfirst.common.listener.MyListener;
import com.allfirst.common.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**容器配置注册三大组件
 *配置嵌入式Servlet容器
 * Spring boot 默认是不支持 JSP 的，所以想用 JSP 就必须使用外部容器来运行。
 * Spring boot 默认为我们提供了注册 Servlet 三大组件 Servlet、Filter、Listener 的接口。
 * 我们只需按需配置和添加少量的代码即可实现添加 Servlet 的功能。
 */
@Configuration
public class MyServerConfig {

    //注册三大组件 Servlet、Filter、Listener
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }


    //配置嵌入式的Servlet容器的相关配置
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {

            //定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
//                container.setPort(8083);
            }
        };
    }

}
