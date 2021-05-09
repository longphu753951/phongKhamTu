package com.phutl.service;

import com.phutl.model.DangKy;

import java.util.List;

public interface DangKyService {
    List<DangKy> selectDangKys();
    boolean addDangKy(DangKy dangKy);
    boolean updateDangKy(DangKy p);
    DangKy selectDangKybyId(int id);
}
