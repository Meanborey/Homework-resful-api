package com.istad.data_analytics_restful_api.controller;

import com.istad.data_analytics_restful_api.model.User;
import com.istad.data_analytics_restful_api.model.UserAccount;
import com.istad.data_analytics_restful_api.service.UserService;
import com.istad.data_analytics_restful_api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserRestController {
    private final UserService userService;
    @Autowired
    UserRestController(UserService userService){

        this.userService = userService;
    }
    private boolean UserExists(int id) {
        User user = userService.findUserByID(id);
        return user != null;
    }
    private Response<User> NotFound(int id){
        return Response.<User>notFound().setMessage("Cannot find user with id "+id).setSuccess(false).setStatus(Response.Status.NOT_FOUND);
    }
    @GetMapping("/allUsers")
    public List<User> getAllUser(){
        return userService.allUsers();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable int id){
//jessie123 postgres
        return userService.findUserByID(id);
    }
    @PostMapping("/newUser")
    public String createUser(@RequestBody User user){

        try{
            int affectRow= userService.createNewUser(user);
            if (affectRow >0) {
                return "Create user successfully";

            }else {
                return "Can not create a new user";
            }
        }catch (Exception exception){
            return exception .getMessage();
        }
//        return "creat user successfully!";
    }
    @PutMapping("/update/{id}")
    public Response<User> updateUser(@PathVariable int id, @RequestBody User user){
        try{
            if(UserExists(id)){
                user.setUserId(id);
                userService.updateUser(user,id);
                return Response.<User>updateSuccess().setPayload(user).setMessage("Successfully for updated 👍");
            } else {
                return NotFound(id);
            }
        } catch (Exception exception){
            return Response.<User>exception().setSuccess(false).setMessage("Fail for update");
        }
    }
    @DeleteMapping("/delete/{id}")
    public Response<User> deleteUser(@PathVariable int id){
        try {
            if(UserExists(id)){
                userService.removeUser(id);
                return Response.<User>deleteSuccess().setMessage("Successfully for deleted👍");
            }
            else {
                return NotFound(id);
            }
        } catch (Exception exception){
            return Response.<User>exception().setMessage("Fail for delete  ").setSuccess(false);
        }
    }
    @GetMapping("/userAccount")
    public Response<List<UserAccount>> getAllUserAccount(){
        try {
            List<UserAccount> userAccounts = userService.getAllUserAccount();
            return Response.<List<UserAccount>>ok().setPayload(userAccounts).setMessage("Successfully Retrieved all User Account information");
        }catch (Exception e){
            return Response.<List<UserAccount>>ok().setMessage("Exception !").setSuccess(false);
        }
    }



}
