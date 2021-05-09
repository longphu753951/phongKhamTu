package com.phutl.controller;


import com.phutl.model.Category;
import com.phutl.model.Medicine;
import com.phutl.service.CategoryService;
import com.phutl.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@SessionAttributes("categories")
public class MedicineController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/admin/Medicine/add")
    public String ProductAdd(Model model){
        Medicine medicine = new Medicine();
        model.addAttribute("medicine", medicine);

        return "addMedicine";
    }

    @PostMapping("/admin/Medicine/add/save")
    public String saveThuoc(@ModelAttribute("medicine") @Valid Medicine medicine,
                            @RequestParam("chonLoai") String chonLoai ,
                            @RequestParam("img") MultipartFile img,
                            BindingResult result, Model model,
                            HttpServletRequest request) throws Exception{
        Category c = categoryService.getCategoryById(Integer.parseInt(chonLoai));
        medicine.setCategory(c);
        String rootDir = request.getSession()
                .getServletContext().getRealPath("/");

        if (img != null && !img.isEmpty()) {
            try {
                img.transferTo(new File(rootDir + "resources/images/"
                        + img.getOriginalFilename()));
            } catch (IOException | IllegalStateException ex) {
                System.err.println(ex.getMessage());
            }

            medicine.setPic("/images/"+img.getOriginalFilename());

            this.medicineService.addOrUpdateMedicine(medicine);
        }
        return "redirect:/admin/Medicine";
    }

    @RequestMapping("/admin/Medicine")
    public String medicineList(Model model){
        model.addAttribute("medicines", this.medicineService.getMedicines());
        return "medicineManager";
    }

    @GetMapping(value = "/admin/Medicine/delete/{id}")
    public String deleteCategory(@PathVariable int id, Model m){
        this.medicineService.deleteMedicine(id);
        return "redirect:/admin/Medicine";
    }

    @ModelAttribute("categories")
    public List<Category> initializeProfiles() {

        return categoryService.getCategories();
    }
}
