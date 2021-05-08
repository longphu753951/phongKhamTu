package com.phutl.controller;

import com.phutl.model.Category;
import com.phutl.model.Medicine;
import com.phutl.service.CategoryService;
import com.phutl.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
public class ProductManagerController {

    @RequestMapping(value = "/admin/ProductManager")
    public String ProductManager(){
        return "productManager";
    }


}
