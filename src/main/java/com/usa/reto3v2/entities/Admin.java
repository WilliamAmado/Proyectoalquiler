package com.usa.reto3v2.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="admin")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String user;
    private String password;

    public Admin() {
    }

    public Admin(Integer id, String name, String user, String password) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
