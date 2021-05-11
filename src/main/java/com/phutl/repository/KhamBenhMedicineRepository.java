package com.phutl.repository;

import com.phutl.model.KhamBenhMedicine;

import java.util.List;

public interface KhamBenhMedicineRepository {
    List<KhamBenhMedicine> selectByKhamBenhId(int khamBenhId);
    boolean addOrUpdateKhamBenhMedicine(KhamBenhMedicine kbm);
}
