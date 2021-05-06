package com.phutl.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "medicine", schema = "phongtu")
public class Medicine implements Serializable {

    @Id
    @Column(name = "medicine_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineId;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "price" , nullable = false)
    private BigDecimal price;
    

    @ManyToOne
    @JoinColumn(name = "category_Id", referencedColumnName = "category_Id", nullable = false)
    private Category category;

    public Medicine() {
    }

    public Medicine(Integer medicineId, String fullname, BigDecimal price, Category category) {
        this.medicineId = medicineId;
        this.fullname = fullname;
        this.price = price;
        this.category = category;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
