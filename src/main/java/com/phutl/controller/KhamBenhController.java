package com.phutl.controller;


import com.phutl.model.KhamBenh;
import com.phutl.model.KhamBenhMedicine;
import com.phutl.model.Medicine;
import com.phutl.service.KhamBenhMedicineService;
import com.phutl.service.KhamBenhService;
import com.phutl.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private KhamBenhMedicineService khamBenhMedicineService;

    private KhamBenh khamBenhCt;

    @RequestMapping("/admin/khamBenh")
    public String khamBenhMain(Model model){
        model.addAttribute("khamBenhs", khamBenhService.khamBenhByDay());
        return "khamBenhMain";
    }

    @RequestMapping("/admin/approve")
    public String khamBenhApprove(HttpSession session){
        List<KhamBenhMedicine> cart = (List<KhamBenhMedicine>) session.getAttribute("cart");
        khamBenhCt.setTinhTrang(1);
        khamBenhService.addOrUpdateKhamBenh(khamBenhCt);
        for(KhamBenhMedicine khamBenhMedicine: cart){
            khamBenhMedicineService.addOrUpdateKhamBenhMedicine(khamBenhMedicine);
        }
        return "redirect:/admin/khamBenh";
    }


    @PostMapping("/admin/khamBenh/detail/redirect")
    public RedirectView khamBenhChiTiet(@RequestParam("nguyenNhan") String nguyenNhan,
                                        @RequestParam("loiKhuyen") String loiKhuyen,
                                        @RequestParam("money") String tienKham){
        khamBenhCt.setNguyenNhan(nguyenNhan);
        khamBenhCt.setLoiKhuyen(loiKhuyen);
        khamBenhCt.setTienKham(new BigDecimal(tienKham));
        return new RedirectView("/phongKhamTu_war/admin/khambenh/chonThuoc");
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

    @GetMapping("/admin/khambenh/chonthuoc/checklist/remove/{index}")
    public String remove(@PathVariable("index") String index, HttpSession session){
        List<KhamBenhMedicine> cart = (List<KhamBenhMedicine>) session.getAttribute("cart");
        cart.remove(Integer.parseInt(index));
        session.setAttribute("cart", cart);
        return "redirect:/admin/khambenh/chonthuoc/checklist";
    }

    @GetMapping("/admin/khambenh/chonthuoc/checklist")
    public String checkList(HttpSession session, Model model){
        List<KhamBenhMedicine> cart = (List<KhamBenhMedicine>) session.getAttribute("cart");
        BigDecimal tongTien = new BigDecimal(0);
        for (KhamBenhMedicine khamBenhMedicine: cart) {
            tongTien = tongTien.add(khamBenhMedicine.getTotalPrice());
        }
        tongTien =tongTien.add(khamBenhCt.getTienKham());
        khamBenhCt.setTongTien(tongTien);
        model.addAttribute("tienKham", khamBenhCt.getTienKham());
        model.addAttribute("totalPrice", tongTien);
        return "checkList";
    }

    @PostMapping("/admin/khambenh/chonthuoc/checklist/update")
    public String update(HttpSession session, HttpServletRequest request){
            int index = Integer.parseInt(request.getParameter("itemIndex"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            List<KhamBenhMedicine> cart = (List<KhamBenhMedicine>) session.getAttribute("cart");
            cart.get(index).setQuantity(quantity);
            cart.get(index).setTotalPrice(new BigDecimal(cart.get(index).getPrice().intValue()*quantity));
            return "redirect:/admin/khambenh/chonthuoc/checklist";
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
