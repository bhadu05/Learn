package com.Assignment1.Controller;

import com.Assignment1.Models.UserWallet;
import com.Assignment1.ParamCheck.ParamCheck;
import com.Assignment1.Service.UserService;
import com.Assignment1.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;
@RestController
public class WalletController {

    @Autowired
    WalletService walletService;


    //API which will create a wallet for a user.
    @PostMapping("/wallet")
    UserWallet createWallet(@RequestParam String mobileNumber)
    {
        if(ParamCheck.checkMobileNumber(mobileNumber))
            return walletService.createWallet(mobileNumber);
        else
            throw new InvalidParameterException("Invalid Parameters");

    }
}
