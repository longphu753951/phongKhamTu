package com.phutl.controller;

import com.phutl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/admin/test")
    public String test(Model model) {
        model.addAttribute("categories",
                this.categoryService
                        .getCategories());
        return "index";
    }
}
