package me.seung.miniproject_seung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import org.springframework.ui.Model;

@Controller
@Slf4j
public class customerController {

    @RequestMapping("/")
    public String home() {
        log.info("home");
        return "index";
    }
 
    @GetMapping("/customer/list")
    public String customerList(Model model) {
        System.out.println("/customer/list");
        // select

        return "list";
    }
}