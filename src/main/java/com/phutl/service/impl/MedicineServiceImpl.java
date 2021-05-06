package com.phutl.service.impl;

import com.phutl.model.Medicine;
import com.phutl.repository.MedicineRepository;
import com.phutl.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getMedicines() {
        return this.medicineRepository.getMedicines();
    }

    @Override
    public boolean addOrUpdateMedicine(Medicine p) {
        return this.medicineRepository.addOrUpdateMedicine(p);
    }

    @Override
    public boolean deleteMedicine(int medicineId) {
        return this.medicineRepository.deleteMedicine(medicineId);
    }

    @Override
    public Medicine getMedicineById(int medicineId) {
        return this.medicineRepository.getMedicineById(medicineId);
    }

    @Override
    public List<Medicine> getMedicinesByName(String name) {
        return this.medicineRepository.getMedicinesByName(name);
    }
}
