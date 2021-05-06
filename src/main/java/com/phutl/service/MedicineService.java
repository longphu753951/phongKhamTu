package com.phutl.service;

import com.phutl.model.Medicine;

import java.util.List;

public interface MedicineService {
    List<Medicine> getMedicines();
    boolean addOrUpdateMedicine(Medicine p);
    boolean deleteMedicine(int medicineId);
    Medicine getMedicineById(int medicineId);
    List<Medicine> getMedicinesByName(String name);
}
