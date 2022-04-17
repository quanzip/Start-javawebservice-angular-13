package com.example.backend.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;


@Entity
@Table(name = "pet")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "leg")
    private Integer leg;

    @Column(name = "normal_name", length = 300)
    private String normalName;

    public Pet(Integer id, Integer leg, String normalName) {
        this.id = id;
        this.leg = leg;
        this.normalName = normalName;
    }

    public Pet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeg() {
        return leg;
    }

    public void setLeg(Integer leg) {
        this.leg = leg;
    }

    public String getNormalName() {
        return normalName;
    }

    public void setNormalName(String normalName) {
        this.normalName = normalName;
    }
}
