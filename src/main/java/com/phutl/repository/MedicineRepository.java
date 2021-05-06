package com.phutl.repository;

import com.phutl.model.Medicine;

import java.util.List;

public interface MedicineRepository {
    List<Medicine> getMedicines();
    boolean addOrUpdateMedicine(Medicine p);
    boolean deleteMedicine(int medicineId);
    Medicine getMedicineById(int medicineId);
    List<Medicine> getMedicinesByName(String name);
}
