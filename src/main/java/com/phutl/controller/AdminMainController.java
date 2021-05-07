package com.phutl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMainController {
    @RequestMapping(value = {"/admin/","/admin"})
    public String index(Model model){

        return "adminMain";
    }

}
