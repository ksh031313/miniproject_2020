package me.seung.miniproject_seung;

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
        // select

        return "list";
    }
}