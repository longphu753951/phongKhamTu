package com.phutl.repository;

import com.phutl.model.KhamBenh;

import java.util.List;

public interface KhamBenhRepository {
    List<KhamBenh> khamBenhLists();
    boolean addOrUpdateKhamBenh(KhamBenh k);
    KhamBenh getKhamBenhById(int id);
    List<KhamBenh> khamBenhByDay();
}
