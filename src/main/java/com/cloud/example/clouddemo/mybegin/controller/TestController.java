package com.cloud.example.clouddemo.mybegin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2020/5/13 16:30
 */
@RestController
@RequestMapping("/test")
@Api(value = "测试 控制器", tags = "API-测试控制器")
public class TestController {

    @PostMapping(value = "/testPost")
    @ApiOperation(value = "测试")
    public String addDrone(@RequestBody String test) {
        System.out.println(test);
        return test;
    }

    @GetMapping(value = "/testHello")
    @ApiOperation(value = "测试")
    public String testHello() {
        return "helloworld++++2345678910";
    }

    @GetMapping(value = "/testfwxnc")
    @ApiOperation(value = "测试")
    public String testfwxnc() {
        return "testfwxnc123457";
    }
}
