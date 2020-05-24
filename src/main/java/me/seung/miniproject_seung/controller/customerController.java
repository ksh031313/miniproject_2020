package me.seung.miniproject_seung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import me.seung.miniproject_seung.domain.Address;
import me.seung.miniproject_seung.domain.Customer;
import me.seung.miniproject_seung.domain.Person;
import lombok.RequiredArgsConstructor;
import me.seung.miniproject_seung.service.CustomerService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    
    @GetMapping("/customers/new")
    public String createForm(Model model) {
        model.addAttribute("customerForm", new CustomerForm());
        return "customers/createCustomerForm";
    }

    @PostMapping("/customers/new")
    public String create(@Valid CustomerForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "customers/createCustomerForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
        
        Customer customer = new Person();
        customer.setName(form.getName());
        customer.setAddress(address);

        customerService.join(customer);
        
        return "redirect:/customers/list";
    }
    
    @GetMapping("/customers/list")
    public String list(Model model) {
        List<Customer> customers = customerService.findCustomers();
        model.addAttribute("customers", customers);

        return "customers/customerList";
    }

}