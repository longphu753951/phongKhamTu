package com.phutl.service;

import com.phutl.model.KhamBenh;

import java.util.List;

public interface KhamBenhService {
    List<KhamBenh> khamBenhLists();
    boolean addOrUpdateKhamBenh(KhamBenh k);
    KhamBenh getKhamBenhById(int id);
    List<KhamBenh> khamBenhByDay();
}
