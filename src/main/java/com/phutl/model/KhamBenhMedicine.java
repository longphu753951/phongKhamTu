package com.phutl.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "khambenh_medicine", schema = "phongtu")
public class KhamBenhMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "medicine_Id", referencedColumnName = "medicine_Id", nullable = false)
    private Medicine medicine;

    @ManyToOne
    @JoinColumn(name = "khamBenh_Id", referencedColumnName = "khamBenh_Id", nullable = false)
    private KhamBenh khamBenh;

    public KhamBenhMedicine() {
    }

    public KhamBenhMedicine(Integer id, int quantity, BigDecimal price, BigDecimal totalPrice, Medicine medicine, KhamBenh khamBenh) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.medicine = medicine;
        this.khamBenh = khamBenh;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public KhamBenh getKhamBenh() {
        return khamBenh;
    }

    public void setKhamBenh(KhamBenh khamBenh) {
        this.khamBenh = khamBenh;
    }
}
