package com.example.demo.Service;

import com.example.demo.generate.Information;
import com.example.demo.generate.InformationDao;
import com.example.demo.generate.User;
import com.example.demo.generate.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class informationService {
    @Autowired(required = false)
    InformationDao informationDao;

    public Information create(String username) {
        try{
            return informationDao.selectByUser(username);
        }catch (Exception e) {
            e.printStackTrace();
            return new Information();
        }
    }

    public int add(Information information) {
        try {
            if (informationDao.selectByUser(information.getUsername()) == null) {
                return informationDao.insertSelective(information);
            } else {
                return informationDao.updateByUsername(information);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
