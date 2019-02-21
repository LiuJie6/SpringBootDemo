package com.example.demo.controller.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name:springbootdemo
 * File Name:HelloWorld
 * Package Name:com.example.demo.controller.demo
 * Date:2019/2/15
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@RestController
@EnableAutoConfiguration
public class HelloWorld {

    @RequestMapping("/hello")
    public String say() {
        System.out.println("Hello springboot");
        return "hello,this is a springboot demo";
    }
}
