package com.Assignment1.Service;

import com.Assignment1.Models.UserWallet;
import com.Assignment1.ParamCheck.CustomException;
import com.Assignment1.Repositories.UserRepository;
import com.Assignment1.Repositories.UserWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
public class WalletService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserWalletRepository userWalletRepository;

    public UserWallet createWallet(String mobileNumber) {

        //Check for validations.
        if(userRepository.findByMobileNumber(mobileNumber)!=null)
        {
            if(userWalletRepository.findByID(mobileNumber)==null)
            {
                return userWalletRepository.save(new UserWallet(mobileNumber));
            }
            else
                throw new CustomException("601","User doesn't have a wallet.");
        }
        else
            throw new CustomException("601","User does not registered.");

    }

}
