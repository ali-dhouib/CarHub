package com.example.testback1.catalog;

import com.example.testback1.car.Car;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class GarageCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "garageCatalog")
    private Set<Car> cars = new HashSet<> ( );

    public void setId (Long id) {
        this.id = id;
    }

    public Long getId () {
        return id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setCode (String code) {
        this.code = code;
    }

    public void setCars (Set<Car> cars) {
        this.cars = cars;
    }

    public String getName () {
        return name;
    }

    public String getCode () {
        return code;
    }

    public Set<Car> getCars () {
        return cars;
    }
}