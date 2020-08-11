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
- 使用Docker:
- 整合Druid数据源:配置类DruidConfig.java
- 整合mybatis:配置类MyBatisConfig.java
- 缓存:
   1. @Cacheable:详解看EmployeeServiceImpl.java,EmployeeController.java
   2. @CacheEvict:详解看EmployeeServiceImpl.java,EmployeeController.java
   3. @CachePut:详解看EmployeeServiceImpl.java,EmployeeController.java
   4. redis：spring的cache可以使用redis进行缓存，相结合，使用了缓存管理器。如何整合详解看DepartmentServiceImpl.java,DeptController.java
     - docker启动redis
- RabbitMQ:自动配置(docker启动RabbitMQ)
1. RabbitAutoConfiguration
2. 有自动配置了连接工厂ConnectionFactory；
3. RabbitProperties 封装了 RabbitMQ的配置
4. RabbitTemplate ：给RabbitMQ发送和接受消息；
5.  - AmqpAdmin ： RabbitMQ系统管理功能组件;
    - AmqpAdmin：创建和删除 Queue，Exchange，Binding
6. @EnableRabbit +  @RabbitListener 监听消息队列的内容
7. 消息发送先前往消息交换机，再根据交换机中队列的Routing key往符合规则的队列发送消息。
```linux
docker run -d -p 5672:5672 -p 15672:15672 --name 容器名 容器ID
```
- 检索elasticsearch(注意springbootES需对应ES版本)
   - 索引对应数据库；类型对应表；文档对应表中记录；属性对应列
   - SpringBoot默认支持两种技术来和ES交互；
     - Jest（默认不生效）(测试案例有bug可能是版本问题)
      	需要导入jest的工具包（io.searchbox.client.JestClient）
     - SpringData ElasticSearch【ES版本有可能不合适】
      		版本适配说明：https://github.com/spring-projects/spring-data-elasticsearch
     		如果版本不适配：2.4.6 。
     		 1. 升级SpringBoot版本
    		 2. 安装对应版本的ES
     
        1. Client 节点信息clusterNodes；clusterName
      	2. ElasticsearchTemplate 操作es
     	3. 编写一个 ElasticsearchRepository 的子接口来操作ES；
     	4. 两种用法：https://github.com/spring-projects/spring-data-elasticsearch
     	5. 编写一个 ElasticsearchRepository
- 任务：
    1. 异步任务：
     - @EnableAsync：开启基于注解的异步任务
     - @Async标注的方法，称之为异步方法；这些方法将在执行的时候，将会在独立的线程中被执行，调用者无需等待它的完成，即可继续其他的操作。
    2. 定时任务：
     - @EnableScheduling：开启基于注解的定时任务
     - @Scheduled：代表这是个定时任务，会按照时间定时触发运行标注的方法
    3. 邮件功能：
     - 需要引入mail-staster依赖
     - 配置mail参数application.properties
     - 操作看Springboot04TaskApplicationTests.java
- 安全：
    - 使用SpringSecurity的流程
      1. 引入SpringSecurity；
      2. 编写SpringSecurity的配置类；
         ```
          @EnableWebSecurity   extends WebSecurityConfigurerAdapter
         ```     		
      3. 控制请求的访问权限：
         ```
         configure(HttpSecurity http) {
          		 	http.authorizeRequests().antMatchers("/").permitAll()
          		 		.antMatchers("/level1/**").hasRole("VIP1")
          		}
         ```  
      4. 定义认证规则：
         ```
      		configure(AuthenticationManagerBuilder auth){
      		 	auth.inMemoryAuthentication()
      		 		.withUser("zhangsan").password("123456").roles("VIP1","VIP2")
      		}
         ```
      5. 开启自动配置的登陆功能：
            ```
      		configure(HttpSecurity http){
      		 	http.formLogin();
      		}
            ```
      6. 注销：
            ```
            http.logout();
            ```
      7. 记住我：
            ```
            Remeberme()；
            ```