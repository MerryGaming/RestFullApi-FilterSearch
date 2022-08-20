package org.aibles.worker2.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import liquibase.pro.packaged.T;
import org.springframework.data.jpa.domain.Specification;

public class SearchSpecificationBuilder {
  private final List<SearchCriteria> searchCriteriaList;

  public SearchSpecificationBuilder() {
    this.searchCriteriaList = new ArrayList<>();
  }

  public SearchSpecificationBuilder with(String fidd, Object value) {
    searchCriteriaList.add(new SearchCriteria(fidd, value));
    return this;
  }

  public Specification<T> build() {
    if (searchCriteriaList.size() == 0) {
      return null;
    }
    List<Specification<T>> specifications =
        searchCriteriaList.stream().map(SearchSpecification::new).collect(Collectors.toList());
    Specification<T> result = specifications.get(0);
    for (int i = 1; i < searchCriteriaList.size(); i++) {
      result = Specification.where(result).and(specifications.get(i));
    }
    return result;
  }

}
