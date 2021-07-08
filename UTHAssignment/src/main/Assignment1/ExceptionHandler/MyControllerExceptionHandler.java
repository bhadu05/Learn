package com.Assignment1.ExceptionHandler;

import com.Assignment1.ParamCheck.CustomException;
import com.sun.javaws.exceptions.InvalidArgumentException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.InvalidAlgorithmParameterException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class MyControllerExceptionHandler {


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleInvalidArgument(CustomException invalidArgumentException)
    {
        return new ResponseEntity<String>(invalidArgumentException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> tokenExpired(ExpiredJwtException expiredJwtException)
    {
        expiredJwtException.getMessage();
        return new ResponseEntity<String >(expiredJwtException.getMessage(),HttpStatus.FORBIDDEN);
    }
    
    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ResponseEntity<String >unuthorisedUser(InternalAuthenticationServiceException internalAuthenticationServiceException)
    {
        return new ResponseEntity<String>("Invalid username or password.", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> handleDulplicates(SQLIntegrityConstraintViolationException invalidArgumentException)
    {
        invalidArgumentException.getMessage();
        return new ResponseEntity<String>(invalidArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
