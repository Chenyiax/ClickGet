package com.example.demo.Service;


import com.example.demo.generate.User;
import com.example.demo.generate.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired(required = false)
    UserDao userDao;

    public String login(User user) {
        try{
            if(userDao.selectByPrimaryKey(user.getUsername()).getPassword().equals(user.getPassword())) {
                return "success";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return "Wrong password";
    }

    public String register(User user) {
        try{
            if(userDao.selectByPrimaryKey(user.getUsername()).getUsername().equals(user.getUsername())) {
                return "repeat of user name";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        try{
            if(userDao.insert(user) == 1) {
                return "success";
            } else {
                return "fail";
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return "error";
    }
}
