package com.shopping.mall.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(description = "用户")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object create(@RequestParam("id")Integer id) {
        return null;
    }

}
