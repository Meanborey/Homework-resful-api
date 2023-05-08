package com.istad.data_analytics_restful_api.controller;

import com.github.pagehelper.PageInfo;
import com.istad.data_analytics_restful_api.model.User;
import com.istad.data_analytics_restful_api.model.UserAccount;
import com.istad.data_analytics_restful_api.model.request.UserRequest;
import com.istad.data_analytics_restful_api.model.response.AccountResponse;
import com.istad.data_analytics_restful_api.service.UserService;
import com.istad.data_analytics_restful_api.utils.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserRestController {
    private final UserService userService;


    public UserRestController(UserService userService) {
        this.userService = userService;
    }


//    private boolean UserExists(int id) {
//        User user = userService.findUserByID(id);
//        return user != null;
//    }
//    private Response<User> NotFound(int id){
//        return Response.<User>notFound().setMessage("Cannot find user with id "+id).setSuccess(false).setStatus(Response.Status.NOT_FOUND);
//    }
    @GetMapping("/allUsers")
    public Response<PageInfo<User>> getAllUser(@RequestParam (defaultValue = "1") int page,
                                               @RequestParam(defaultValue = "5") int size,
                                               @RequestParam(defaultValue = "", required = false) String  username) {
        try {
           PageInfo<User> response = userService.allUsers(page,size,username);
            return Response.<PageInfo<User>>ok().setPayload(response).setMessage("Successfully retrieved all users ! ");

        } catch (Exception ex) {
            System.out.println("Exception : "+ex.getMessage());
            return Response.<PageInfo<User>>exception().setMessage("Failed to retrieved the users ! Exception occurred ! ");
        }

    }
    //

    @GetMapping("/{id}")
    public Response<User> findUserByID(@PathVariable int id) {
        try {
            User response = userService.findUserByID(id);
            if (response != null) {
                return Response.<User>ok().setPayload(response).setSuccess(true).setMessage("Successfully retrieved user with id = " + id);
            } else {
                return Response.<User>notFound().setMessage("User with id =" + id + " doesn't exist ").setSuccess(false);
            }
        } catch (Exception ex) {
            return Response.<User>exception().setMessage("Failed to retrieved user with id =" + id);
        }

    }
    @PostMapping("/newUser")
    public Response<User> createUser(@Valid @RequestBody UserRequest request) {

        try {
            int userID = userService.createNewUser(request);
            if (userID > 0) {

                User response = new User().setUsername(request.getUsername())
                        .setAddress(request.getAddress())
                        .setGender(request.getGender()).setUserId(userID);

                return Response.<User>createSuccess().setPayload(response).setMessage("Create User Successfully").setSuccess(true);
            } else {
                return Response.<User>badRequest().setMessage("Bad Request ! Failed to create user");
            }


        } catch (Exception ex) {

            return Response.<User>exception().setMessage("Exception occurs! Failed to create a new user ").setSuccess(false);
        }


    }
    @PutMapping("/{id}")
    public Response<User> updateUserByID(@PathVariable int id, @RequestBody UserRequest request) {

        try {
            int affectedRow = userService.updateUser(request, id);
            if (affectedRow > 0) {
                User response = new User().setUserId(id).setUsername(request.getUsername())
                        .setAddress(request.getAddress()).setGender(request.getGender());

                return Response.<User>updateSuccess().setMessage("Successfully update the user ")
                        .setPayload(response).setSuccess(true);
            } else {
                return Response.<User>notFound().setMessage("Cannot update , user with id = " + id + " doesn't exist ! ").setSuccess(false);
            }
        } catch (Exception ex) {
            return Response.<User>exception().setMessage("Failed to update user , Exception Occurred!");
        }

    }
    @DeleteMapping("/delete/{id}")
    public Response<?> deleteUser(@PathVariable int id) {
        try {
            int affectedRow = userService.removeUser(id);
            if (affectedRow > 0) {
                // delete success
                return Response.<Object>deleteSuccess().setMessage("Successfully remove the user ! ").setSuccess(true);
            } else {
                // id do not exist !
                return Response.<Object>notFound().setMessage("User with id =" + id + " doesn't exist in our system !");
            }

        } catch (Exception ex) {
            return Response.<Object>exception().setMessage("Exception occurred! Failed to delete the user !").setSuccess(false);
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
