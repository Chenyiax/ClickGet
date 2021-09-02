package com.example.demo.Controller;


import com.example.demo.Service.informationService;
import com.example.demo.generate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.generate.Information;
@CrossOrigin
@RestController
@RequestMapping("/information")
public class informationContorller {
    @Autowired
    informationService informationService;

    @PostMapping("/create")
    @ResponseBody
    public Information create(@RequestBody String username) {
        return informationService.create(username);
    }

    @PostMapping("/add")
    @ResponseBody
    public int add(@RequestBody Information information) {
        return informationService.add(information);
    }

}
