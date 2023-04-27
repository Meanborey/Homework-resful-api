package com.istad.data_analytics_restful_api.repository;

import com.istad.data_analytics_restful_api.model.Account;
import com.istad.data_analytics_restful_api.model.AccountType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AccountRepository {
    @Result(column = "account_type", property = "accountType", one = @One(select = "getAccountTypeByID"))
    @Select("select * from account_tb")
    List<Account> getAllAccount();

    @Select("select * from accounttype_tb where id = #{account_type} ")
    AccountType getAccountTypeByID(int account_type);
    int createAccount(Account account);

    int updateAccount(Account account, int id);

    Account findAccountByID(int id);
}
