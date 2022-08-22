package org.aibles.worker2.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.aibles.worker2.entity.Worker;
import org.springframework.data.jpa.domain.Specification;

public class SearchSpecificationBuilder {
  private final List<SearchCriteria> searchCriteriaList;

  public SearchSpecificationBuilder() {
    this.searchCriteriaList = new ArrayList<>();
  }

  public SearchSpecificationBuilder with(String fidd, String operation, String value) {
    searchCriteriaList.add(new SearchCriteria(fidd, operation, value));
    return this;
  }

  public Specification<Worker> build() {
    if (searchCriteriaList.size() == 0) {
      return null;
    }
    List<Specification<Worker>> specifications =
        searchCriteriaList.stream().map(SearchSpecification::new).collect(Collectors.toList());
    Specification<Worker> result = specifications.get(0);
    for (int i = 1; i < searchCriteriaList.size(); i++) {
      result = Specification.where(result).and(specifications.get(i));
    }
    return result;
  }

}
