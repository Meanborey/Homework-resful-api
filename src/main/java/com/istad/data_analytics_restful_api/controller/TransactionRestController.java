package com.istad.data_analytics_restful_api.controller;


import com.github.pagehelper.PageInfo;
import com.istad.data_analytics_restful_api.model.Transaction;
import com.istad.data_analytics_restful_api.service.TransactionService;
import com.istad.data_analytics_restful_api.utils.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionRestController {
    private final TransactionService transactionService;
    @GetMapping("/AllTransaction")
    Response<PageInfo<Transaction>> AllTransaction(@RequestParam(defaultValue = "1") int pageNum,
                                                      @RequestParam(defaultValue = "5") int pageSize,
                                                      @RequestParam(defaultValue = "", required = false)  int filter){
        try {
            PageInfo<Transaction> allTransaction=transactionService.AllTransaction(pageNum,pageSize,filter);
            return Response.<PageInfo<Transaction>>ok().setPayload(allTransaction).setMessage("Success!");
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return Response.<PageInfo<Transaction>>exception().setMessage("data not found!");
        }
    }
    @PostMapping("/create-new-transaction")
    public Response<Transaction> createNewTransaction(@Valid @RequestBody Transaction transaction){
        int created_new= transactionService.createdNewTransaction(transaction);
        if (created_new>0){
            return Response.<Transaction>ok().setPayload(transaction).setSuccess(true).setMessage("successfully");
        }else {
            return Response.<Transaction>notFound().setPayload(null)
                    .setSuccess(false)
                    .setMessage("Transaction not found!");
        }
    }
    @DeleteMapping("/{id}")
    public Response<Void> deleteTransaction(@PathVariable int id) {
        try{
            int deleted = transactionService.deleteTransaction(id);
            if (deleted > 0) {
                return Response.<Void>ok().setMessage("Successfully delete").setSuccess(true);
            } else {
                return Response.<Void>notFound().setMessage("none data for delete!");
            }
        }catch (Exception e){
            return Response.<Void>exception().setSuccess(true).setMessage("Search data not found!");
        }
    }
    @PutMapping("/{id}")
    public Response<Void> updateTransaction(@PathVariable int id,
                                            @RequestBody Transaction transaction) {
        try {
            transaction.setId(id);
            int updated = transactionService.updateTransaction(transaction);
            if (updated > 0) {
                return Response.<Void>ok().setSuccess(true).setMessage("Successfully for Update!");
            } else {
                return Response.<Void>notFound().setSuccess(false).setMessage("Update is failed!");
            }
        }catch (Exception e){
            return Response.<Void>exception().setSuccess(false).setMessage("Data not found!");
        }
    }

}

