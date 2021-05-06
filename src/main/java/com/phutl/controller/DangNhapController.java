package com.phutl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DangNhapController {

    @GetMapping("/login")
    public String dangNhap( Model model){
        return "login";
    }
}
