package com.example.demo.generate;

import java.io.Serializable;


/**
 * user
 * @author 
 */
public class User implements Serializable {
    private String username;

    private String password;

    private static final long serialVersionUID = 1L;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}