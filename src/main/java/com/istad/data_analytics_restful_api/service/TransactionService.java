package com.istad.data_analytics_restful_api.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.transaction.Transaction;

public interface TransactionService {
    PageInfo<Transaction>AllTransaction(int pageNum, int pageSize, int filter);

    int createdNewTransaction(Transaction transaction);
    int deleteTransaction(int id);
    int updateTransaction(Transaction transaction);
}
