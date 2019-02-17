package com.andyfan.tx.controller;

import com.zk.lock.zklock.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andyFan
 * @since 2019年01月14日
 */
@RestController
public class StarterController {
    @Autowired
    private ExampleService exampleService;

    @RequestMapping("/test")
    public String get() {
        return exampleService.wrap("jjj");
    }
}
