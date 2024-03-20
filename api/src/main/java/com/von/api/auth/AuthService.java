package com.von.api.auth;

import com.von.api.user.User;

import java.util.List;
import java.util.Map;

// login, join
public interface AuthService {

    String addUsers();
    public String join(User user);
    public String login(User user);
    //p.658 #HashMap
    User findUserById(String username);

    String updatePassword(User user);
    String deleteUser(String username);

    List<?> getUserList();
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> getUserMap();
    String countUsers();
    String changePw();



}
