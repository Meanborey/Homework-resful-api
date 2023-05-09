package com.istad.data_analytics_restful_api.repository;

import com.istad.data_analytics_restful_api.model.Transaction;
import com.istad.data_analytics_restful_api.repository.provider.TransactionProvider;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface TransactionRepository {
    @SelectProvider(type = TransactionProvider.class, method = "AllTransaction")
     List<Transaction> AllTransaction(int filter);
    @InsertProvider(type = TransactionProvider.class, method = "insertTransaction")
//    @SelectProvider(type = TransactionProvider.class,method = "insertTransaction")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertTransaction(Transaction transaction);

    @DeleteProvider(type = TransactionProvider.class, method = "deleteTransaction")
    int deleteTransaction(@Param("id") int id);

    @UpdateProvider(type = TransactionProvider.class, method = "updateTransaction")
    int updateTransaction(Transaction transaction);

}
