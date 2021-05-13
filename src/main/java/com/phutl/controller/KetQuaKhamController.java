package com.phutl.controller;

import com.phutl.model.KhamBenh;
import com.phutl.model.KhamBenhMedicine;
import com.phutl.service.KhamBenhMedicineService;
import com.phutl.service.KhamBenhService;
import com.phutl.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KetQuaKhamController {

    @Autowired
    private KhamBenhService khamBenhService;

    @Autowired
    private KhamBenhMedicineService khamBenhMedicineService;

    @RequestMapping(value = "/ketQuaKhamBenh")
    public String ketQuaKhamBenh(Model model){
        return "ketQuaKham";
    }

    @RequestMapping(value = "/ketQuaKhamBenh/result")
    public String ketQua(Model model,
                         @RequestParam("maBenh") String maBenh){
        KhamBenh kb = this.khamBenhService.getKhamBenhById(Integer.parseInt(maBenh));
        List<KhamBenhMedicine> kbm = this.khamBenhMedicineService.selectByKhamBenhId(Integer.parseInt(maBenh));
        model.addAttribute("kb", kb);
        model.addAttribute("kbm", kbm);
        return "ketQuaDetail";
    }
}
