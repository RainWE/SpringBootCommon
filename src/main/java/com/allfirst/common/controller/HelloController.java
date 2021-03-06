package com.allfirst.common.controller;

import com.allfirst.common.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 页面跳转测试
 */
@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/query")
    public Map<String, Object> map() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * FROM department");
        return list.get(0);
    }

//    @RequestMapping("/")
//    public String sayHello(){
//        return "index_th";
//    }

    /**
     * 测试定制错误UserNotExistException
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")) {
            //抛出UserNotExistException异常
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    //查出用户数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }


}
