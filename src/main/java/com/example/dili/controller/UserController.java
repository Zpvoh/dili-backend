package com.example.dili.controller;

import com.example.dili.model.ResponseStatus;
import com.example.dili.model.User;
import com.example.dili.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public ResponseStatus UserRegister(@RequestBody User userInfo){
        return userService.registerUser(userInfo);
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public Object UserLogin(@RequestBody User userInfo){
        return userService.loginUser(userInfo);
    }
}
