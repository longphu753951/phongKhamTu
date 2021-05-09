package com.phutl.repository;

import com.phutl.model.DangKy;

import java.util.List;

public interface DangKyRepository {
    List<DangKy> selectDangKys();
    boolean addDangKy(DangKy p);
    boolean updateDangKy(DangKy p);
    DangKy selectDangKybyId(int id);
}
