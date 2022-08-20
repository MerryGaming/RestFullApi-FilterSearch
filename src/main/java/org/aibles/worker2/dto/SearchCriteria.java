package org.aibles.worker2.dto;


import java.util.Objects;
import lombok.Data;

@Data
public class SearchCriteria {
  private String fidd;
  private String geration;
  private Objects value;

  public SearchCriteria(String fidd, Object value) {
  }
}
