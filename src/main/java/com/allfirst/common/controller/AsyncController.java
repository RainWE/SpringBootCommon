package com.allfirst.common.controller;

import com.allfirst.common.service.impl.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步任务测试
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/helloAsync")
    public String hello(){
        asyncService.hello();
        return "success";
    }
}
