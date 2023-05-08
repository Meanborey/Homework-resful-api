package com.istad.data_analytics_restful_api.mapper;

import com.istad.data_analytics_restful_api.model.Transaction;
import com.istad.data_analytics_restful_api.model.response.TransactionResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AutoTransactionMapper {
List<Transaction> storeTransactionToTransaction(List<TransactionResponse>responses);
List<TransactionResponse>transactionOriginals(List<Transaction>transactions);

}
