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

    @ManyToOne
    @JoinColumn(name = "medicine_Id", referencedColumnName = "medicine_Id", nullable = false)
    private Medicine medicine;

    @ManyToOne
    @JoinColumn(name = "khamBenh_Id", referencedColumnName = "khamBenh_Id", nullable = false)
    private KhamBenh khamBenh;
}
