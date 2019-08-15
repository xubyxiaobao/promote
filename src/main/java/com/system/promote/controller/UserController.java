package com.system.promote.controller;

import com.system.promote.common.Result;
import com.system.promote.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/findAll")
    public Result findAll(){
        return Result.returnSuccess(userService.findAll());
    }
}
