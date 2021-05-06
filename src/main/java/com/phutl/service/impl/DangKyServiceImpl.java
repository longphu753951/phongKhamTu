package com.phutl.service.impl;

import com.phutl.model.DangKy;
import com.phutl.repository.DangKyRepository;
import com.phutl.service.DangKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DangKyServiceImpl implements DangKyService {

    @Autowired
    private DangKyRepository dangKyRepository;

    @Override
    public boolean addDangKy(DangKy dangKy) {
        return this.dangKyRepository.addDangKy(dangKy);
    }
}
