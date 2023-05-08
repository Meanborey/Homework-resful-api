package com.istad.data_analytics_restful_api.repository.provider;

import com.istad.data_analytics_restful_api.model.Transaction;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class TransactionProvider {
    public static String getAllTransactions(int filters){
        return new SQL(){{

            SELECT("*");
            FROM("transaction_tb");
            if (filters!=0){
                WHERE("sender_account_id = #{filter}");
            }
        }}.toString();
    }
    public String insertTransaction(Transaction transaction) {
        return new SQL() {{
            INSERT_INTO("transaction_tb");
            VALUES("sender_account_id", "#{sender_account_id}");
            VALUES("receiver_account", "#{receiver_account}");
            VALUES("amount", "#{amount}");
            VALUES("remark", "#{remark}");
            VALUES("transfer_at", "localtimestamp");
        }}.toString();
    }
    public String deleteTransaction(@Param("id") int id) {
        return new SQL() {{
            DELETE_FROM("transaction_tb");
            WHERE("id = #{id}");
        }}.toString();
    }
    public String updateTransaction(Transaction transaction) {
        return new SQL() {{
            UPDATE("transaction_tb");
            SET("sender_account_id = #{sender_account_id}");
            SET("receiver_account = #{receiver_account}");
            SET("amount = #{amount}");
            SET("remark = #{remark}");
            SET("transfer_at = localtimestamp");
            WHERE("id = #{id}");
        }}.toString();
    }
}