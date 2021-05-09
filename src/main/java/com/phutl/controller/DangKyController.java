package com.phutl.controller;

import com.phutl.model.Category;
import com.phutl.model.DangKy;
import com.phutl.service.DangKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DangKyController {

    @Autowired
    private DangKyService dangKyService;

    @GetMapping(value = "/dangKyLichKham")
    public String dangKyLichKham(Model model){
            DangKy dangKy = new DangKy();
            model.addAttribute("dangKy", dangKy);
            return "dangKyLichKham";
    }

    @GetMapping(value = "/admin/listDangKy")
    public String danhSachDangKy(Model model){
        model.addAttribute("dangKys", dangKyService.selectDangKys());
        return "dangKyList";
    }

    @PostMapping(value = "/saveDangKy")
    public String saveDangKy(@ModelAttribute("dangKy") @DateTimeFormat(pattern = "yyyy-MM-dd") @Valid DangKy dangKy, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "dangKyLichKham";
        }
        dangKy.setTinhTrang(0);
        if (!this.dangKyService.addDangKy(dangKy)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "dangKyLichKham";
        }
        return "redirect:/";
    }

    @GetMapping(value = "/admin/dangky/detail/{id}")
    public String dangKyDetail(@PathVariable int id, Model m){
        DangKy dangKy = this.dangKyService.selectDangKybyId(id);
        m.addAttribute("dangKy", dangKy);
        return "dangKyDetail";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

}
