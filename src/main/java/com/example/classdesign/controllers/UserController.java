package com.example.classdesign.controllers;

import com.example.classdesign.results.Result;
import com.example.classdesign.results.SuccessResult;
import com.example.classdesign.services.Userservice;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/USER/")
public class UserController {

    @Autowired
    Userservice userservice;

    @ApiOperation(value = "create", notes = "新建", response = Result.class)
    @PostMapping(value = "/create/")
    public Result signin(@ApiParam(value = "username" ,required=true ) @RequestParam String username,
                         @ApiParam(value = "userpsw " ,required=true ) @RequestParam String password){
        return userservice.createUser(username,password);
    }
    @ApiOperation(value = "login", notes = "登录", response = Result.class)
    @PostMapping(value = "/login/")
    public  Result login(){
        return new SuccessResult();
    }


}
