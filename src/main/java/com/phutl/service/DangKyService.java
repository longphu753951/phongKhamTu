package com.phutl.service;

import com.phutl.model.DangKy;

public interface DangKyService {
    boolean addDangKy(DangKy dangKy);
    boolean updateDangKy(DangKy p);
    DangKy selectDangKybyId(int id);
}
