package com.istad.data_analytics_restful_api.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.istad.data_analytics_restful_api.repository.TransactionRepository;
import com.istad.data_analytics_restful_api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionRepository autoTransactionMapper;

    @Override
    public PageInfo<Transaction> getAllTransaction(int page, int size, int filter) {
        PageHelper.startPage(page, size);
        List<Transaction> transactionList=autoTransactionMapper.getAllTransactions(filter);
        PageInfo<Transaction> pageInfo = new PageInfo<>(transactionList);
        return pageInfo;
    }
//    public PageInfo<Transaction> getAllTransaction(int page, int size, int filter) {
//        PageHelper.startPage(page, size);
//        return new PageInfo<>(transactionRepository.getAllTransactions(filter));
//    }
    @Override
    public int createdNewTransaction(Transaction transaction) {

        return autoTransactionMapper.insertTransaction(transaction);
    }

    @Override
    public int deleteTransaction(int id) {

        return autoTransactionMapper.deleteTransaction(id);
    }

    @Override
    public int updateTransaction(Transaction transaction) {
        return autoTransactionMapper.updateTransaction(transaction);
    }
}
