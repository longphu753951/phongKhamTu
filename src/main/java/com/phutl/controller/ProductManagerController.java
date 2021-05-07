package com.phutl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductManagerController {

    @RequestMapping(value = "/admin/ProductManager")
    public String ProductManager(){
        return "productManager";
    }
}
