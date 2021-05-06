package com.phutl.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "category", schema = "phongtu")
public class Category implements Serializable {

    @Id
    @Column(name = "category_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<Medicine> medicines;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(Collection<Medicine> medicines) {
        this.medicines = medicines;
    }
}