package me.seung.miniproject_seung.repository;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import me.seung.miniproject_seung.domain.Customer;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private final EntityManager em;

    public void save(Customer customer) {
        em.persist(customer);
    }

    public Customer findOne(Long id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        return em.createQuery("select c from Customer c", Customer.class)
                .getResultList();
    }

    public List<Customer> findByName(String name) {
        return em.createQuery("select c from Customer c where c.name = :name", Customer.class)
                .setParameter("name", name)
                .getResultList();
    }

}