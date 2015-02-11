package com.clinic.helpers;

import org.springframework.stereotype.Component;

import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;

@Component("jpahelper")
public class JPAHelper {
    public Object getSingleResultOrNull(Query query){
        List results = query.getResultList();
        if (results.isEmpty()) return null;
        else if (results.size() == 1) return results.get(0);
        throw new NonUniqueResultException();
    }
}
