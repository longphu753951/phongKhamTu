package com.phutl.model;


import javax.persistence.*;

@Entity
@Table(name = "user", schema = "phongtu")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private Integer user_Id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    private String userRole;

    public User() {
    }

    public User(Integer user_Id, String userName, String password, String userRole) {
        this.user_Id = user_Id;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
