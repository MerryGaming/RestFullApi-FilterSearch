package org.aibles.worker2.exeption;

import org.aibles.worker2.exeption.handle.ExceptionHandle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String message, HttpStatus httpStatus){
        super(message,httpStatus);
    }
}
