package com.istad.data_analytics_restful_api.service;

import com.istad.data_analytics_restful_api.model.Account;

import java.awt.*;
import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    int createAccount(Account account);
    int updateAccount(Account account,int id);
    Account findAccountByID(int id);
}
