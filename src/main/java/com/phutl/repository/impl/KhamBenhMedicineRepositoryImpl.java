package com.phutl.repository.impl;

import com.phutl.model.KhamBenhMedicine;
import com.phutl.repository.KhamBenhMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.List;

public class KhamBenhMedicineRepositoryImpl implements KhamBenhMedicineRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<KhamBenhMedicine> selectByKhamBenhId(int khamBenhId) {
        return null;
    }

    @Override
    public boolean addOrUpdateKhamBenhMedicine(KhamBenhMedicine kbm) {
        return false;
    }
}
