package com.phutl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KetQuaKhamController {

    @RequestMapping(value = "/ketQuaKhamBenh")
    public String ketQuaKhamBenh(Model model){
        return "ketQuaKham";
    }
}
