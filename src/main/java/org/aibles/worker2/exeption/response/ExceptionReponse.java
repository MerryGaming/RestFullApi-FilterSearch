package org.aibles.worker2.exeption.response;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class ExceptionReponse {
    private String error;
    private String message;
    private Instant timeStamp;


}
