package com.istad.data_analytics_restful_api.model.response;

import com.istad.data_analytics_restful_api.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private int id;
    private String account_no;
    private String account_name;
    private String profile;
    private String phone_number;
    private int transfer_limit;
    private int account_type;
//   private AccountType accountType;
    private AccountType accountType;

}
