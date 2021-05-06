package com.phutl.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "dangKy", schema = "phongtu")
public class DangKy implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "dangKy_Id")
    private int dangKyId;

    @Column(name = "ho", nullable = false)
    private String ho;

    @Column(name = "ten", nullable = false)
    private String ten;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "sdt", nullable = false)
    private String sdt;

    @Column(name = "ngayKham", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKham;

    @Column(name = "buoiKham", nullable = false)
    private int buoiKham;

    @Column(name = "trieuChung", nullable = false)
    private String trieuChung;

    @Value("${some.key:0}")
    @Column (name = "tinhTrang")
    private Integer tinhTrang;

    public DangKy() {
    }

    public DangKy(int dangKyId, String ho, String ten, String email, String sdt, Date ngayKham, int buoiKham, String trieuChung, Integer tinhTrang) {
        this.dangKyId = dangKyId;
        this.ho = ho;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.ngayKham = ngayKham;
        this.buoiKham = buoiKham;
        this.trieuChung = trieuChung;
        this.tinhTrang = tinhTrang;
    }

    public int getBuoiKham() {
        return buoiKham;
    }

    public void setBuoiKham(int buoiKham) {
        this.buoiKham = buoiKham;
    }

    public int getDangKyId() {
        return dangKyId;
    }

    public void setDangKyId(int dangKyId) {
        this.dangKyId = dangKyId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}