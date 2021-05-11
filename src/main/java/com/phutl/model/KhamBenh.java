package com.phutl.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "khambenh", schema = "phongtu")
public class KhamBenh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khamBenh_Id")
    private Integer khamBenh_Id;

    @Column(name = "ho", nullable = false)
    private String ho;

    @Column(name = "ten", nullable = false)
    private String ten;

    @Column(name = "ngayKham", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKham;

    @Column(name = "gioKham", nullable = false)
    private LocalTime gioKham;

    @Column(name = "tinhTrang")
    private int tinhTrang;

    @Column(name = "nguyenNhan")
    private String nguyenNhan;

    @Column(name = "loiKhuyen")
    private String loiKhuyen;

    @Column(name = "tongTien")
    private BigDecimal tongTien;

    @Column(name = "tienKham")
    private BigDecimal tienKham;

    @OneToMany(mappedBy = "khamBenh", cascade = CascadeType.ALL)
    private Collection<KhamBenhMedicine> khamBenhMedicines;

    public KhamBenh() {
    }

    public KhamBenh(Integer khamBenh_Id, String ho, String ten, Date ngayKham, LocalTime gioKham, int tinhTrang, String nguyenNhan, String loiKhuyen, BigDecimal tongTien, Collection<KhamBenhMedicine> khamBenhMedicines) {
        this.khamBenh_Id = khamBenh_Id;
        this.ho = ho;
        this.ten = ten;
        this.ngayKham = ngayKham;
        this.gioKham = gioKham;
        this.tinhTrang = tinhTrang;
        this.nguyenNhan = nguyenNhan;
        this.loiKhuyen = loiKhuyen;
        this.tongTien = tongTien;
        this.khamBenhMedicines = khamBenhMedicines;
    }

    public Integer getKhamBenh_Id() {
        return khamBenh_Id;
    }

    public void setKhamBenh_Id(Integer khamBenh_Id) {
        this.khamBenh_Id = khamBenh_Id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public LocalTime getGioKham() {
        return gioKham;
    }

    public void setGioKham(LocalTime gioKham) {
        this.gioKham = gioKham;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getNguyenNhan() {
        return nguyenNhan;
    }

    public void setNguyenNhan(String nguyenNhan) {
        this.nguyenNhan = nguyenNhan;
    }

    public String getLoiKhuyen() {
        return loiKhuyen;
    }

    public void setLoiKhuyen(String loiKhuyen) {
        this.loiKhuyen = loiKhuyen;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public Collection<KhamBenhMedicine> getKhamBenhMedicines() {
        return khamBenhMedicines;
    }

    public BigDecimal getTienKham() {
        return tienKham;
    }

    public void setTienKham(BigDecimal tienKham) {
        this.tienKham = tienKham;
    }

    public void setKhamBenhMedicines(Collection<KhamBenhMedicine> khamBenhMedicines) {
        this.khamBenhMedicines = khamBenhMedicines;
    }
}
