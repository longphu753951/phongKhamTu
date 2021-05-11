package com.phutl.controller;


import com.phutl.model.KhamBenh;
import com.phutl.service.KhamBenhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KhamBenhController {

    @Autowired
    private KhamBenhService khamBenhService;
    private KhamBenh khamBenhCt;

    @RequestMapping("/admin/khamBenh")
    public String khamBenhMain(Model model){
        model.addAttribute("khamBenhs", khamBenhService.khamBenhByDay());
        return "khamBenhMain";
    }

    @GetMapping("/admin/khamBenh/detail/{id}")
    public String khamBenhChiTiet(@PathVariable int id, Model m){
        khamBenhCt = this.khamBenhService.getKhamBenhById(id);
        m.addAttribute("khamBenhCt", khamBenhCt);
        return "khamBenhCt";
    }

    @PostMapping("/admin/khambenh/chonThuoc")
    public String chonThuoc(@RequestParam("nguyenNhan") String nguyenNhan,
                            @RequestParam("loiKhuyen") String loiKhuyen
                            ){
        khamBenhCt.setNguyenNhan(nguyenNhan);
        khamBenhCt.setLoiKhuyen(loiKhuyen);
        return "redirect:/admin";
    }
}
