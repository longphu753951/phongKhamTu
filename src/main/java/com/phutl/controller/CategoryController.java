package com.phutl.controller;

import com.phutl.model.Category;
import com.phutl.model.DangKy;
import com.phutl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/admin/caterogy")
    public String test(Model model) {
        model.addAttribute("categories",
                this.categoryService
                        .getCategories());
        return "categoryManager";
    }

    @GetMapping(value = "/admin/category/add")
    public String addCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "addCategory";
    }

    @PostMapping(value = "/admin/category/add/save")
    public String saveDangKy(@ModelAttribute("category") @Valid Category category, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "/admin/caterogy";
        }

        if (!this.categoryService.addOrUpdateCategory(category)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "/admin/caterogy";
        }
        return "redirect:/admin/caterogy";
    }

    @GetMapping(value = "/admin/category/delete/{id}")
    public String deleteCategory(@PathVariable int id, Model m){
        this.categoryService.deleteCategory(id);
        return "redirect:/admin/caterogy";
    }

    @GetMapping(value = "/admin/category/edit/{id}")
    public String editCategory(@PathVariable int id, Model m){
        Category category = this.categoryService.getCategoryById(id);
        m.addAttribute("category", category);
        return "editCategory";
    }

    @PostMapping(value = "/admin/category/edit/save")
    public String editDangKySave(@ModelAttribute("category") @Valid Category category, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "/admin/caterogy";
        }

        if (!this.categoryService.addOrUpdateCategory(category)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "/admin/caterogy";
        }
        return "redirect:/admin/caterogy";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }


}
