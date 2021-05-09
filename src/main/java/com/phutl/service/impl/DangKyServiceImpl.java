package com.phutl.service.impl;

import com.phutl.model.DangKy;
import com.phutl.repository.DangKyRepository;
import com.phutl.service.DangKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DangKyServiceImpl implements DangKyService {

    @Autowired
    private DangKyRepository dangKyRepository;

    @Override
    public List<DangKy> selectDangKys() {
        return this.dangKyRepository.selectDangKys();
    }

    @Override
    public boolean addDangKy(DangKy dangKy) {
        return this.dangKyRepository.addDangKy(dangKy);
    }

    @Override
    public boolean updateDangKy(DangKy p) {
        return this.dangKyRepository.updateDangKy(p);
    }

    @Override
    public DangKy selectDangKybyId(int id) {
        return this.dangKyRepository.selectDangKybyId(id);
    }
}
