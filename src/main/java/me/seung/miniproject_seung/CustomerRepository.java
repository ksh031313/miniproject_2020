package me.seung.miniproject_seung;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager em;

    public Integer save(Customer customer) {
        em.persist(customer);
        return customer.getCustId();
    }

    public Customer find(Integer custId) {
        return em.find(Customer.class, custId);
    }
}