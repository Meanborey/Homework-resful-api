package com.istad.data_analytics_restful_api.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.istad.data_analytics_restful_api.model.Transaction;
import com.istad.data_analytics_restful_api.repository.TransactionRepository;
import com.istad.data_analytics_restful_api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionRepository autoTransactionMapper;

    @Override
    public PageInfo<Transaction> AllTransaction(int pageNum, int pageSize, int filter) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(transactionRepository.AllTransaction(filter));
    }
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
