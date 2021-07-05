package com.Assignment1.Controller;

import com.Assignment1.Models.UserWallet;
import com.Assignment1.ParamCheck.ParamCheck;
import com.Assignment1.Service.service;
import com.Assignment1.Models.User;
import com.Assignment1.Models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@RestController
public class Controller {

    @Autowired
    service service;

    //API which will create a user in the table.
    @PostMapping("/user")
    public User createUser(@RequestBody User user)
    {
        if(ParamCheck.checkUser(user))
        {
            System.out.println(user.getAddress1());
            return service.createUser(user);
        }
        else
         throw new InvalidParameterException("Invalid Parameters in user");
    }


    //API which will read data from database.
    @GetMapping("/user")
    public User findUser(@RequestParam Long userID)
    {
        if(ParamCheck.checkUserID(userID))
        return service.findUser(userID);
        else
            throw new InvalidParameterException("Invalid Parameters");
    }


    //Update API
    @PutMapping("/user")
    public String updateUser(@RequestParam Long userID,@RequestBody User user)
    {
        if(ParamCheck.checkUserID(userID) && ParamCheck.checkUser(user))
        return service.updateUser(userID,user);
        else
            throw new InvalidParameterException("Invalid Parameters");

    }


    //API which will delete data in the user table.
    @DeleteMapping("/user")
    public String deleteUser(@RequestParam Long userID)
    {
        if(ParamCheck.checkUserID(userID))
        return service.deleteUser(userID);
        else
            throw new InvalidParameterException("Invalid Parameters");
    }

    //API which will create a wallet for a user.
    @PostMapping("/wallet")
    UserWallet createWallet(@RequestParam String mobileNumber)
    {
        if(ParamCheck.checkMobileNumber(mobileNumber))
            return service.createWallet(mobileNumber);
        else
            throw new InvalidParameterException("Invalid Parameters");

    }

    //API to transfer money from one wallet to another wallet.
    @PostMapping("/transaction")
    public String doTransaction(String payerNumber,String payeeNumber,Double amount)
    {
        if(ParamCheck.checkMobileNumber(payerNumber) && ParamCheck.checkMobileNumber(payeeNumber) && ParamCheck.checkBalance(amount))
        {
           return "Transaction Id is"+service.doTransaction(payerNumber, payeeNumber, amount).getTransactionID();

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
            return service.getTransactionSummary(userID);
        }
        else
            throw new InvalidParameterException("Invalid Parameters");
    }

    //Transaction status.
    @GetMapping(value = "/transaction",params = "transactionID")
    public Transaction getTransactionStatus(@RequestParam String transactionID)
    {
        if(ParamCheck.checkTransactionID(transactionID))
            return service.getTransactionStatus(transactionID);
        else
            throw new InvalidParameterException("Invalid Parameters");
    }

}
