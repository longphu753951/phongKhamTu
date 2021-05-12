package com.phutl.service;

import com.phutl.model.KhamBenhMedicine;

import java.util.List;

public interface KhamBenhMedicineService {
    List<KhamBenhMedicine> selectByKhamBenhId(int khamBenhId);
    boolean addOrUpdateKhamBenhMedicine(KhamBenhMedicine kbm);
}
