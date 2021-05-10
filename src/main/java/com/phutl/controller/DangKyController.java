package com.phutl.controller;

import com.phutl.model.Category;
import com.phutl.model.DangKy;
import com.phutl.model.KhamBenh;
import com.phutl.service.DangKyService;
import com.phutl.service.KhamBenhService;
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
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Controller
public class DangKyController {

    @Autowired
    private DangKyService dangKyService;

    @Autowired
    private KhamBenhService khamBenhService;

    private DangKy dangKyGb;

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
        dangKyGb = this.dangKyService.selectDangKybyId(id);
        m.addAttribute("dangKy", dangKyGb);
        return "dangKyDetail";
    }

    @GetMapping(value = "/admin/dangky/detail/cancel")
    public String dangKyDetailCancel(){
        dangKyGb.setTinhTrang(-1);
        this.dangKyService.updateDangKy(dangKyGb);
        return "redirect:/admin/listDangKy";
    }

    @PostMapping(value = "/admin/dangKy/detail/approve")
    public String dangKyDetailApprove(@RequestParam(value = "chonGio") String gio){
        String[] time = gio.split(":");
        int hour =  Integer.parseInt(time[0].trim());
        int minute =  Integer.parseInt(time[1].trim());
        KhamBenh kb = new KhamBenh();
        kb.setHo(dangKyGb.getHo());
        kb.setTen(dangKyGb.getTen());
        kb.setNgayKham(dangKyGb.getNgayKham());
        kb.setGioKham(LocalTime.of(hour,minute));
        khamBenhService.addOrUpdateKhamBenh(kb);
        dangKyGb.setTinhTrang(1);
        this.dangKyService.updateDangKy(dangKyGb);
        return "redirect:/admin/listDangKy";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));

    }

}
