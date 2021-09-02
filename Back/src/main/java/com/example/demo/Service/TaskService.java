package com.example.demo.Service;

import com.example.demo.generate.Task;
import com.example.demo.generate.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TaskService {
    @Autowired(required = false)
    TaskDao taskDao;

    public String addTask(Task task) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        task.setTemp(0);
        task.setIsaccepted(false);
        task.setIscomplete(false);
        task.setDate(dateNowStr);
        try{
            if(taskDao.insertSelective(task) == 1) {
                return "success";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "error";
    }
    public int plustemp(Task task) {
        try {
            Task task1 = taskDao.temp(task.getTitle());
            task1.setTemp(task1.getTemp()+1);
            return taskDao.updateByTitle(task1);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    public List<Task> showTask() {
        try{
            List<Task> list =taskDao.selectAll();
            Collections.reverse(list);
            return list;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Task> showMyTask(Task task) {
        try{
            System.out.println(task.toString());
            List<Task> list =taskDao.selectMytask(task.getUser1());
            Collections.reverse(list);
            return list;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Task> get(Task task) {
        try{
            List<Task> list =taskDao.get(task.getUser2());
            Collections.reverse(list);
            return list;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return Collections.emptyList();
    }

    public int change(Task task) {
        try {
            return taskDao.updateByTitle(task);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public List<Task> searchTask(Task task) {
        String record = task.getTitle();

        try {
            if(record == null) {
                List<Task> list = taskDao.selectAll();
                Collections.reverse(list);
                return list;
            } else {
                List<Task> list = taskDao.searchTask(record);
                Collections.reverse(list);
                return list;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return Collections.emptyList();
    }
}
