package com.phutl.service.impl;

import com.phutl.model.KhamBenh;
import com.phutl.repository.KhamBenhRepository;
import com.phutl.service.KhamBenhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhamBenhServiceImpl implements KhamBenhService {

    @Autowired
    private KhamBenhRepository khamBenhRepository;

    @Override
    public List<KhamBenh> khamBenhLists() {
        return this.khamBenhRepository.khamBenhLists();
    }

    @Override
    public boolean addOrUpdateKhamBenh(KhamBenh k) {
        return this.khamBenhRepository.addOrUpdateKhamBenh(k);
    }

    @Override
    public KhamBenh getKhamBenhById(int id) {
        return this.khamBenhRepository.getKhamBenhById(id);
    }

    @Override
    public List<KhamBenh> khamBenhByDay() {
        return this.khamBenhRepository.khamBenhByDay();
    }
}
