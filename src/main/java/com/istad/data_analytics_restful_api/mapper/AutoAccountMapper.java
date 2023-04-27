package com.istad.data_analytics_restful_api.mapper;

import com.istad.data_analytics_restful_api.model.Account;
import com.istad.data_analytics_restful_api.model.response.AccountResponse;
import org.mapstruct.Mapper;

import javax.security.auth.login.AccountException;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AutoAccountMapper {
    //we can 2 method
    //account->accountresponse
//   List<AccountResponse> mapToAccountResponses(List<Account> accounts);
    List<AccountResponse> mapToAccountResponse(List<Account> accounts);

    List<Account> mapToAccounts(List<AccountResponse>accountResponses);


}
