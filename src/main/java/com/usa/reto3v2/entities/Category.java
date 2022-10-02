package com.usa.reto3v2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (length = 45)
    private String name;
    @Column (length = 250)
    private String description;

    @OneToMany(mappedBy = "category",cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("category")
    private List<Motorbike> motorbikes;

    public Category() {
        motorbikes=new ArrayList<Motorbike>();
    }

    public Category(Integer id) {
        this.id = id;
        motorbikes=new ArrayList<Motorbike>();
    }

    public List<Motorbike> getMotorbikes() {
        return motorbikes;

    }

    public void setMotorbikes(List<Motorbike> motorbikes) {
        motorbikes = motorbikes;
        motorbikes=new ArrayList<Motorbike>();
    }

    public Category(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        motorbikes=new ArrayList<Motorbike>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
