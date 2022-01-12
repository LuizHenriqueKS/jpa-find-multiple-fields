package com.example.jpafindmultiplefields.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.jpafindmultiplefields.domain.Country;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriteriaPredicateBuilder {

    private final Root<Country> root;
    private final CriteriaBuilder cb;

    private List<Predicate> predicateList = new ArrayList<>();

    public void addContains(String fieldPath, String value) {
        if (value != null) {
            predicateList
                    .add(cb.like(cb.lower(toPath(fieldPath)), "%" + value.toLowerCase().replace(" ", "%") + "%"));
        }
    }

    public void addEquals(String fieldPath, String value) {
        if (value != null) {
            predicateList.add(cb.equal(toPath(fieldPath), value));
        }
    }

    public Predicate build() {
        Predicate[] predicates = new Predicate[predicateList.size()];
        return cb.and(predicateList.toArray(predicates));
    }

    private Expression<String> toPath(String fieldPath) {
        return root.get(fieldPath);
    }

}
