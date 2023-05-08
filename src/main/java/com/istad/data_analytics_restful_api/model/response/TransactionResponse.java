package com.istad.data_analytics_restful_api.model.response;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.transaction.Transaction;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    int sender_account_id;
    int receiver_account;
    double amount;
    String remark;
    String transfer_at;

}
