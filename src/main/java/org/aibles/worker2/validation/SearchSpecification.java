package org.aibles.worker2.validation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import liquibase.pro.packaged.T;
import lombok.Data;
import org.aibles.worker2.entity.Worker;
import org.aibles.worker2.validation.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

@Data

public class SearchSpecification<T> implements Specification<T> {
  private SearchCriteria criteria;

  public SearchSpecification(SearchCriteria criteria) {
    this.criteria = criteria;
  }

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder)  {

    if (criteria.getOperation().equalsIgnoreCase(">")) {
      return builder.greaterThanOrEqualTo(
          root.<String>get(criteria.getFidd()), criteria.getValue().toString());
    } else if (criteria.getOperation().equalsIgnoreCase("<")) {
      return builder.lessThanOrEqualTo(
          root.<String>get(criteria.getFidd()), criteria.getValue().toString());
    } else if (criteria.getOperation().equalsIgnoreCase("=")) {
      if (root.get(criteria.getFidd()).getJavaType() == String.class) {
        return builder.like(root.<String>get(criteria.getFidd()), "%" + criteria.getValue() + "%");
      } else {
        return builder.equal(root.get(criteria.getFidd()), criteria.getValue());
      }
    }

    return null;
  }


}
