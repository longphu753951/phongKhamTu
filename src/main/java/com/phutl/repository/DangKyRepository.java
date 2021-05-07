package com.phutl.repository;

import com.phutl.model.DangKy;

public interface DangKyRepository {
    boolean addDangKy(DangKy p);
    boolean updateDangKy(DangKy p);
    DangKy selectDangKybyId(int id);
}
