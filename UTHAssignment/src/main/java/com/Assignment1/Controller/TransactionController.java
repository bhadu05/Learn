package com.Assignment1.Controller;

import com.Assignment1.Models.Transaction;
import com.Assignment1.ParamCheck.ParamCheck;
import com.Assignment1.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    //API to transfer money from one wallet to another wallet.
    @PostMapping("/transaction")
    public Transaction doTransaction(String payerNumber,String payeeNumber,Double amount)
    {
        if(ParamCheck.checkMobileNumber(payerNumber) && ParamCheck.checkMobileNumber(payeeNumber) && ParamCheck.checkBalance(amount))
        {
            return transactionService.doTransaction(payerNumber, payeeNumber, amount);

        }
        else
            throw new InvalidParameterException("Invalid parameters");

    }

    //Transaction summery API.
    @GetMapping(value = "/transaction",params = "userID")
    public Page<Transaction> getTransactionSummary(@RequestParam Long userID)
    {
        if(ParamCheck.checkUserID(userID))
        {
            return transactionService.getTransactionSummary(userID);
        }
        else
            throw new InvalidParameterException("Invalid Parameters");
    }

    //Transaction status.
    @GetMapping(value = "/transaction",params = "transactionID")
    public Transaction getTransactionStatus(@RequestParam String transactionID)
    {
        if(ParamCheck.checkTransactionID(transactionID))
            return transactionService.getTransactionStatus(transactionID);
        else
            throw new InvalidParameterException("Invalid Parameters");
    }
}
