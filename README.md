# SpringBootCommon
SpringBootCommon
- 使用log日志整合:直接在application.properties中配置
- 使用thymeleaf整合：详细规则参考文档写法
- RestfulCRUD
  1. 配置springmvc,扩展SpringMVC的功能——MyMvcConfig.java
  2. 国际化： 配置参数i18n,国际化参数配置类——MyLocaleResolver.java，最后在
MyMvcConfig.java中加入容器
  3. 拦截器，页面跳转：在MyMvcConfig.java配置,定义拦截器规则——LoginHandlerInterceptor.java
  4. emp中员工的CRUD
- 错误处理机制:一但系统出现4xx或者5xx之类的错误；ErrorPageCustomizer就会生效（定制错误的响应规则),就会来到/error请求；就会被BasicErrorController处理；
然后响应页面；去哪个页面是由DefaultErrorViewResolver解析得到的。
所以出现hello()出现异常先到MyErrorAttributes.java->再到MyExceptionHandler.java->再抛出UserNotExistException异常
  1. 定义异常处理器——MyExceptionHandler.java
  2. 自定义异常类——UserNotExistException.java,该类继承了RuntimeException.java
  3. 测试见HelloController.java,hello()方法。
  
- 配置嵌入式Servlet容器:  
  1. 案例MyServerConfig.java中注册三大组件Servlet、Filter、Listener
  2. 继承接口自定义组件MyServlet.java、MyFilter.java、MyListener.java
  3. 修改Servlet容器的相关配置
    - 在application.properties中直接修改
    - 或使用 EmbeddedServletContainerCustomizer(详细看MyServerConfig.java)
```  
       @Bean
       public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
           return new EmbeddedServletContainerCustomizer() {
   
               //定制嵌入式的Servlet容器相关的规则
               @Override
               public void customize(ConfigurableEmbeddedServletContainer container) {
                   container.setPort(8083);
               }
           };
       }
```
- 使用Docker
- 整合Druid数据源
    
- 整合mybatis
    