package me.seung.miniproject_seung.controller;

import java.util.List;
import javax.validation.Valid;

import me.seung.miniproject_seung.domain.Address;
import me.seung.miniproject_seung.domain.Company;
import me.seung.miniproject_seung.domain.CustType;
import me.seung.miniproject_seung.domain.Customer;
import me.seung.miniproject_seung.domain.Person;
import me.seung.miniproject_seung.repository.CustomerSearch;
import me.seung.miniproject_seung.service.CustomerService;

import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    
    @GetMapping("/customers/new")
    public String createForm(Model model) {
        CustomerForm customerForm = new CustomerForm();
        customerForm.setCustType("PERSON");
        model.addAttribute("customerForm", customerForm);
        return "customers/createCustomerForm";
    }

    @PostMapping("/customers/new")
    public String create(@Valid CustomerForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "customers/createCustomerForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        if ("PERSON".equals(form.getCustType())) {
            Person customer = new Person();
            customer.setName(form.getName());
            customer.setCustType(CustType.PERSON);
            customer.setLineAmt(form.getLineAmt());
    
            customer.setAddress(address);

            customer.setSsan(form.getSsan());
            customer.setPhoneNum(form.getPhoneNum());
            
            customerService.join(customer);

        } else if ("COMPANY".equals(form.getCustType())) {
            Company customer  = new Company();
            customer.setName(form.getName());
            customer.setCustType(CustType.COMPANY);
            customer.setLineAmt(form.getLineAmt());

            customer.setAddress(address);
            
            customer.setCompRegistNum(form.getCompRegistNum());
            customer.setRepresentName(form.getRepresentName());
            customer.setCompPhoneNum(form.getCompPhoneNum());

            customerService.join(customer);

        }
        
        return "redirect:/customers/list";
    }
    
    @GetMapping("/customers/list")
    public String customerList(@ModelAttribute("customerSearch") CustomerSearch customerSearch, Model model) {
        //List<Customer> customers = customerService.findCustomers();
        List<Customer> customers = customerService.findCustomersByCondition(customerSearch);
        model.addAttribute("customers", customers);

        return "customers/customerList";
    }

}