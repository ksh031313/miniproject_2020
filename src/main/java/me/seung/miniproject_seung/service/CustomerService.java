package me.seung.miniproject_seung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import lombok.RequiredArgsConstructor;
import me.seung.miniproject_seung.domain.Customer;
import me.seung.miniproject_seung.repository.CustomerRepository;
import me.seung.miniproject_seung.repository.CustomerSearch;

@Service
@Transactional(readOnly = true)
//@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 고객등록
    @Transactional
    public Long join(Customer customer) {
        validateDuplicateCustomer(customer);
        customerRepository.save(customer);
        return customer.getId();
    }

    private void validateDuplicateCustomer(Customer customer) {
        List<Customer> findCustomers = customerRepository.findByName(customer.getName());
        if (!findCustomers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 고객입니다.");
        }
    }

    // 고객조회
    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }

    public Customer findOne(Long customerId) {
        return customerRepository.findOne(customerId);
    }

    public List<Customer> findCustomersByCondition(CustomerSearch customerSearch) {
        return customerRepository.findAllByCriteria(customerSearch);
    }
 
}

