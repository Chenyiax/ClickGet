package com.example.demo.Controller;

import com.example.demo.Service.LoginService;
import com.example.demo.generate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService service;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        return service.login(user);
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user) {
        return service.register(user);
    }
}
