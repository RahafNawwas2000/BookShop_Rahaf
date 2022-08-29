package com.example.bookshop.models;

import javax.persistence.*;

@Entity
@Table(name = "Username")
public class Username {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "pass")
    private String Password;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "Roles")
    private String roles;

    public Username() {
        super();
    }

    public Username(int id, String userName, String password, Boolean active, String roles) {
        Id = id;
        this.userName = userName;
        Password = password;
        this.active = active;
        this.roles = roles;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", userName='" + userName + '\'' +
                ", Password='" + Password + '\'' +
                ", active=" + active +
                ", roles='" + roles + '\'' +
                '}';
    }
}
