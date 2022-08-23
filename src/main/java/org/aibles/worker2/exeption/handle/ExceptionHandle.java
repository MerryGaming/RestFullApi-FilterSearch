package org.aibles.worker2.exeption.handle;


import java.time.Instant;
import javax.swing.text.BadLocationException;
import lombok.extern.slf4j.Slf4j;

import org.aibles.worker2.exeption.response.ExceptionReponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionHandle {

    @ExceptionHandler(BadLocationException.class)
    public ExceptionReponse badRequestExceptionHandle(Exception error) {
        log.info("Exception: error:{}, message: {}",HttpStatus.BAD_REQUEST.value(), error.getMessage());
        ExceptionReponse exceptionReponse = new ExceptionReponse();
        exceptionReponse.setError("Bad Error");
        exceptionReponse.setMessage(error.getMessage());
        exceptionReponse.setTimeStamp(Instant.now());
        return exceptionReponse;
    }
}

