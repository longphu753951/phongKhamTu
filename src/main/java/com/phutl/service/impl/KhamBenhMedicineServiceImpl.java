package com.phutl.service.impl;

import com.phutl.model.KhamBenhMedicine;
import com.phutl.repository.KhamBenhMedicineRepository;
import com.phutl.service.KhamBenhMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KhamBenhMedicineServiceImpl implements KhamBenhMedicineService {

    @Autowired
    private KhamBenhMedicineRepository khamBenhMedicineRepository;

    @Override
    public List<KhamBenhMedicine> selectByKhamBenhId(int khamBenhId) {
        return this.khamBenhMedicineRepository.selectByKhamBenhId(khamBenhId);
    }

    @Override
    public boolean addOrUpdateKhamBenhMedicine(KhamBenhMedicine kbm) {
        return this.khamBenhMedicineRepository.addOrUpdateKhamBenhMedicine(kbm);
    }
}
