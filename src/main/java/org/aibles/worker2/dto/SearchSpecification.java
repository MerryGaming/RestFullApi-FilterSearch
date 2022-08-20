package org.aibles.worker2.dto;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import liquibase.pro.packaged.T;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;


public class SearchSpecification implements Specification<T> {
  private SearchCriteria criteria;

  public SearchSpecification(SearchCriteria criteria) {
    this.criteria = criteria;
  }

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder)  {

    if (criteria.getGeration().equalsIgnoreCase(">")) {
      return builder.greaterThanOrEqualTo(
          root.<String>get(criteria.getFidd()), criteria.getValue().toString());
    } else if (criteria.getGeration().equalsIgnoreCase("<")) {
      return builder.lessThanOrEqualTo(
          root.<String>get(criteria.getFidd()), criteria.getValue().toString());
    } else if (criteria.getGeration().equalsIgnoreCase(":")) {
      if (root.get(criteria.getFidd()).getJavaType() == String.class) {
        return builder.like(root.<String>get(criteria.getFidd()), "%" + criteria.getValue() + "%");
      } else {
        return builder.equal(root.get(criteria.getFidd()), criteria.getValue());
      }
    }

    return null;
  }


}
