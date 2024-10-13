package com.fin.splitapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "APP_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String mobile;

    @ManyToMany(mappedBy = "users")
    private List<Group> groups;

    public User() {
        this.groups = new ArrayList<>();
    }

    public User(int userId, String userName, String password, String mobile) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.mobile = mobile;
        this.groups = new ArrayList<>();
    }
}
