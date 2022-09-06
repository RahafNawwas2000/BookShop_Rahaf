package com.example.bookshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
//@Table(name = "LibraryUser")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class LibraryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int Id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "pass")
    private String Password;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "Roles")
    private String roles;


    public LibraryUser() {
        super();
    }

    public LibraryUser(int id, String userName, String password, Boolean active, String roles) {
        Id = id;
        this.userName = userName;
        Password = password;
        this.active = active;
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
