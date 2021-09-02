package com.example.demo.Controller;

import com.example.demo.Service.TaskService;
import com.example.demo.generate.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/homepage")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/addtask")
    @ResponseBody
    public String addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PostMapping("/showtask")
    @ResponseBody
    public List<Task> showTask() {
        return taskService.showTask();
    }

    @PostMapping("/showmytask")
    @ResponseBody
    public List<Task> showMyTask(@RequestBody Task task) {
        return taskService.showMyTask(task);
    }

    @PostMapping("/get")
    @ResponseBody
    public List<Task> get(@RequestBody Task task) {
        return taskService.get(task);
    }


    @PostMapping("/changetask")
    @ResponseBody
    public int change(@RequestBody Task task) {
        return taskService.change(task);
    }

    @PostMapping("/plustemp")
    @ResponseBody
    public int plustemp(@RequestBody Task task) {
        return taskService.plustemp(task);
    }

    @PostMapping("/searchtask")
    @ResponseBody
    public List<Task> searchTask(@RequestBody Task task) {
        return taskService.searchTask(task);
    }
}
