package com.Assignment1.ExceptionHandler;

import com.Assignment1.ParamCheck.CustomException;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.InvalidAlgorithmParameterException;

@ControllerAdvice
public class MyControllerAdvice {


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleInvalidArgument(CustomException invalidArgumentException)
    {
        return new ResponseEntity<String>(invalidArgumentException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }
}
