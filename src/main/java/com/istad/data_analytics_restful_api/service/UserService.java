package com.istad.data_analytics_restful_api.service;

import com.github.pagehelper.PageInfo;
import com.istad.data_analytics_restful_api.model.User;
import com.istad.data_analytics_restful_api.model.UserAccount;
import com.istad.data_analytics_restful_api.model.request.UserRequest;

import java.util.List;

public interface UserService {
    PageInfo<User> allUsers(int page, int size, String filterName);
    List<User> findUserByUsername();



    int createNewUser(UserRequest user);
    int updateUser(UserRequest user, int id);
    User findUserByID(int id);
    int removeUser(int id);
    List<UserAccount>getAllUserAccount();
}

