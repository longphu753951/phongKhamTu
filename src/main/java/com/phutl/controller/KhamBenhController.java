package com.phutl.controller;


import com.phutl.model.KhamBenh;
import com.phutl.service.KhamBenhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class KhamBenhController {

    @Autowired
    private KhamBenhService khamBenhService;

    @RequestMapping("/admin/khamBenh")
    public String khamBenhMain(Model model){
        model.addAttribute("khamBenhs", khamBenhService.khamBenhByDay());
        return "khamBenhMain";
    }
}
