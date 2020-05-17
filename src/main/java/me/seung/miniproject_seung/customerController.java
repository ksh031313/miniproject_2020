package me.seung.miniproject_seung;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

@Controller
public class customerController {

    @GetMapping("/")
    public String startPage() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String openMain() {
        return "index";
    }

    @GetMapping("/customer/list")
    public String customerList(Model model) {
        System.out.println("/customer/list");

        Customer test1 = new Customer();
        test1.setCustId(000);
        test1.setCustName("test1");
        Customer test2 = new Customer();
        test2.setCustId(001);
        test2.setCustName("test2");

         // select
         List<Customer> customerList = new ArrayList<>();
         customerList.add(test1);
         customerList.add(test2);
         model.addAttribute(customerList);
        return "list";
    }
}