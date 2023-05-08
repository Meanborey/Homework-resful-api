package com.istad.data_analytics_restful_api.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.istad.data_analytics_restful_api.model.User;
import com.istad.data_analytics_restful_api.model.UserAccount;
import com.istad.data_analytics_restful_api.model.request.UserRequest;
import com.istad.data_analytics_restful_api.repository.UserRepository;
import com.istad.data_analytics_restful_api.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
@Service

public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public PageInfo<User> allUsers(int page, int size, String filterName) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(userRepository.allUsers(filterName));
    }

    @Override
    public List<User> findUserByUsername() {
        return null;
    }

    @Override
    public int createNewUser(UserRequest user) {
        return userRepository.createNewUser(user);
    }

    @Override
    public int updateUser(UserRequest user, int id) {
        return userRepository.updateUser(user,id);
    }

    @Override
    public User findUserByID(int id) {
        return userRepository.findUserByID(id);
    }

    @Override
    public int removeUser(int id) {
        return userRepository.removeUser(id);
    }

    @Override
    public List<UserAccount> getAllUserAccount() {
        return userRepository.getAllUserAccounts();
    }
}
