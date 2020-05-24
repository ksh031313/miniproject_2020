package me.seung.miniproject_seung.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;
import me.seung.miniproject_seung.domain.Customer;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private final EntityManager em;

    public void save(Customer customer) {
        if (customer.getId() == null) {
            em.persist(customer);
        } else {
            em.merge(customer);
        }
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

    public List<Customer> findList(CustomerSearch customerSearch) {
        return em.createQuery("select c from Customer c" +
                    "where c.custType = :custType" +
                    "and c.name like :name", Customer.class)
                    .setParameter("custType", customerSearch.getCustType())
                    .setParameter("name", customerSearch.getCustomerName())
                    .setMaxResults(1000)
                    .getResultList();
    }

    public List<Customer> findAllByCriteria(CustomerSearch customerSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> o = cq.from(Customer.class);

        List<Predicate> criteria = new ArrayList<>();

        //고객 유형 검색
        if (customerSearch.getCustType() != null) {
            Predicate custType = cb.equal(o.get("custType"), customerSearch.getCustType());
            criteria.add(custType);
        }

        //고객 이름 검색
        if (StringUtils.hasText(customerSearch.getCustomerName())) {
            Predicate name = cb.like(o.get("name"), "%"+customerSearch.getCustomerName()+"%");
            criteria.add(name);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Customer> query = em.createQuery(cq).setMaxResults(1000);

        return query.getResultList();
    }
}