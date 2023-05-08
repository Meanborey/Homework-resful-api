package com.istad.data_analytics_restful_api.repository;


import com.istad.data_analytics_restful_api.repository.provider.TransactionProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface TransactionRepository {
    @SelectProvider(type = TransactionProvider.class, method = "getAllTransactions")
    public List<Transaction> getAllTransactions(int filters);
    @InsertProvider(type = TransactionProvider.class, method = "insertTransaction")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertTransaction(Transaction transaction);

    @DeleteProvider(type = TransactionProvider.class, method = "deleteTransaction")
    int deleteTransaction(@Param("id") int id);

    @UpdateProvider(type = TransactionProvider.class, method = "updateTransaction")
    int updateTransaction(Transaction transaction);

}
