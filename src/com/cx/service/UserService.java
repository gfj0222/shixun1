package com.cx.service;


import java.util.Properties;

public interface UserService {
    Properties login(String name, String password);
    Properties register(String name, String password);
    void exitSystem();
}
