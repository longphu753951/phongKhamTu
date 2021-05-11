package com.phutl.controller;


import com.phutl.model.KhamBenh;
import com.phutl.model.KhamBenhMedicine;
import com.phutl.model.Medicine;
import com.phutl.service.KhamBenhService;
import com.phutl.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KhamBenhController {

    @Autowired
    private KhamBenhService khamBenhService;

    @Autowired
    private MedicineService medicineService;

    private KhamBenh khamBenhCt;

    @RequestMapping("/admin/khamBenh")
    public String khamBenhMain(Model model){
        model.addAttribute("khamBenhs", khamBenhService.khamBenhByDay());
        return "khamBenhMain";
    }


    @GetMapping("/admin/khamBenh/detail/redirect")
    public RedirectView khamBenhChiTiet(@RequestParam("nguyenNhan") String nguyenNhan,
                                  @RequestParam("loiKhuyen") String loiKhuyen){
        khamBenhCt.setNguyenNhan(nguyenNhan);
        khamBenhCt.setLoiKhuyen(loiKhuyen);
        return new RedirectView("/admin/khambenh/chonThuoc");
    }

    @GetMapping("/admin/khamBenh/detail/{id}")
    public String khamBenhChiTiet(@PathVariable int id, Model m){
        khamBenhCt = this.khamBenhService.getKhamBenhById(id);
        m.addAttribute("khamBenhCt", khamBenhCt);
        return "khamBenhCt";
    }

    @RequestMapping(value = "/admin/khambenh/chonThuoc")
    public String chonThuoc(Model model){
        model.addAttribute("medicines",medicineService.getMedicines());
        return "pickMedicine";
    }

    @RequestMapping(value = "/admin/khambenh/chonthuoc/buy/{id}")
    public String buyThuoc(@PathVariable("id") String id, HttpSession session){
        KhamBenhMedicine khamBenhMedicine = new KhamBenhMedicine();
        Medicine medicine = this.medicineService.getMedicineById(Integer.parseInt(id));
        khamBenhMedicine.setPrice(medicine.getPrice());
        khamBenhMedicine.setKhamBenh(khamBenhCt);
        khamBenhMedicine.setMedicine(medicine);
        if(session.getAttribute("cart") == null){
            List<KhamBenhMedicine> cart = new ArrayList<KhamBenhMedicine>();
            khamBenhMedicine.setTotalPrice(new BigDecimal(medicine.getPrice().intValue()*1));
            khamBenhMedicine.setQuantity(1);
            session.setAttribute("cart",cart);
            cart.add(khamBenhMedicine);
        }
        else{
            List<KhamBenhMedicine> cart = (List<KhamBenhMedicine>) session.getAttribute("cart");
            int index = this.exists(id,cart);
            if(index == -1){
                khamBenhMedicine.setTotalPrice(new BigDecimal(medicine.getPrice().intValue()*1));
                khamBenhMedicine.setQuantity(1);
                cart.add(khamBenhMedicine);
            }
            else{
                int quantity = cart.get(index).getQuantity() +1;
                cart.get(index).setQuantity(quantity);
                cart.get(index).setTotalPrice(new BigDecimal(cart.get(index).getPrice().intValue()*quantity));
            }
            session.setAttribute("cart", cart);
        }
        return "redirect:/admin/khambenh/chonThuoc";
    }

    @GetMapping("/admin/khambenh/chonthuoc/remove/{id}")
    public String remove(@PathVariable("id") String id, HttpSession session){
        KhamBenhMedicine khamBenhMedicine = new KhamBenhMedicine();
        List<KhamBenhMedicine> cart = (List<KhamBenhMedicine>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "redirect:/admin/khambenh/chonThuoc";
    }


    private int exists(String id, List<KhamBenhMedicine> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getMedicine().getMedicineId().equals(Integer.parseInt(id))) {
                return i;
            }
        }
        return -1;
    }
}
