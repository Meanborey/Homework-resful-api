package com.istad.data_analytics_restful_api.controller;

import com.istad.data_analytics_restful_api.mapper.AutoAccountMapper;
import com.istad.data_analytics_restful_api.model.Account;
import com.istad.data_analytics_restful_api.model.response.AccountResponse;
import com.istad.data_analytics_restful_api.service.AccountService;

import com.istad.data_analytics_restful_api.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountController {
   private final AccountService accountService;
    private final AutoAccountMapper autoAccountMapper;

    public AccountController(AccountService accountService, AutoAccountMapper autoAccountMapper) {
        this.accountService = accountService;
        this.autoAccountMapper = autoAccountMapper;
    }

    //   final private AutoAccountMapper autoAccountMapper;
//   AccountController


    @GetMapping("/allaccount")
    public Response<List<AccountResponse>> getAllAccount(){
        try{

            List<Account>allAccount=accountService.getAllAccount();
            List<AccountResponse> accountResponses=autoAccountMapper.mapToAccountResponse(allAccount);
            HashMap<String, Object> response = new HashMap<>();
            response.put("payload", accountResponses);
            response.put("message","successfully retrieve all accounts info!");
            response.put("status", HttpStatus.OK);
            return Response.<List<AccountResponse>>ok().setPayload(accountResponses).setMessage("successfully!");
        }catch (Exception ex){
            System.out.println("Some wrong :"+ex.getMessage());
            return Response.<List<AccountResponse>>exception().setMessage("Exception");
        }

    }



}
