package org.aibles.worker2.validation;


import java.util.Objects;
import lombok.Data;

@Data
public class SearchCriteria {
  private String fidd;
  private String operation;
  private Object value;

}
