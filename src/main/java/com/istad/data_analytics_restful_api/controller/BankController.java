//package com.istad.data_analytics_restful_api.controller;
//
//import com.istad.data_analytics_restful_api.mapper.AutoAccountMapper;
//import com.istad.data_analytics_restful_api.model.Account;
//import com.istad.data_analytics_restful_api.model.response.AccountResponse;
//import com.istad.data_analytics_restful_api.service.AccountService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.List;
//@RestController
//@RequestMapping("/account")
//public class BankController {
//    private final AccountService accountService;
//    AutoAccountMapper autoAccountMapper;
//
//    public BankController(AccountService accountService, AutoAccountMapper autoAccountMapper) {
//        this.accountService = accountService;
//        this.autoAccountMapper = autoAccountMapper;
//    }
//
//    //   final private AutoAccountMapper autoAccountMapper;
////   AccountController
//
//
//
//
////    public BankController(AccountService accountService) {
////        this.accountService = accountService;
////    }
//    @GetMapping("/allaccount")
//    public ResponseEntity<?> getAllAccount(){
//        try{
//
//            List<Account> allAccount=accountService.getAllAccount();
//            List<AccountResponse> accountResponses=autoAccountMapper.mapToAccountResponse(allAccount);
//            HashMap<String, Object> response = new HashMap<>();
//            response.put("payload", allAccount);
//            response.put("message","successfully retrieve all accounts info!");
//            response.put("status", HttpStatus.OK);
//            return ResponseEntity.ok().body(response);
//        }catch (Exception ex){
//            System.out.println("Some wrong :"+ex.getMessage());
//            return ResponseEntity.ok().body("Failed ot retreived the account");
//        }
//
//    }
//
//
//}
