package com.example.jpafindmultiplefields.criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.jpafindmultiplefields.domain.Country;
import com.example.jpafindmultiplefields.util.CriteriaPredicateBuilder;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryCriteria implements Specification<Country> {

    private String nameContains;
    private String acronymsEquals;
    private String codeEquals;

    @Override
    public Predicate toPredicate(Root<Country> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        CriteriaPredicateBuilder pb = new CriteriaPredicateBuilder(root, cb);
        pb.addContains("name", nameContains);
        pb.addEquals("acronyms", acronymsEquals);
        pb.addEquals("code", codeEquals);
        return pb.build();
    }

}
