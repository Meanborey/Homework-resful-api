package com.istad.data_analytics_restful_api.service.serviceimpl;

import com.istad.data_analytics_restful_api.model.Account;
import com.istad.data_analytics_restful_api.repository.AccountRepository;
import com.istad.data_analytics_restful_api.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAccountImpl implements AccountService {


   final private  AccountRepository accountRepository;

    public ServiceAccountImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public List<Account> getAllAccount() {
        return accountRepository.getAllAccount();
    }

    @Override
    public int createAccount(Account account) {
        return 0;
    }

    @Override
    public int updateAccount(Account account, int id) {
        return 0;
    }

    @Override
    public Account findAccountByID(int id) {
        return accountRepository.findAccountByID(id);
    }
}
