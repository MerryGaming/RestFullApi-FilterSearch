package org.aibles.worker2.exeption.response;

import java.time.Instant;
import lombok.Data;

@Data
public class ExceptionReponse {
    private String error;
    private String message;
    private Instant timeStamp;



}
