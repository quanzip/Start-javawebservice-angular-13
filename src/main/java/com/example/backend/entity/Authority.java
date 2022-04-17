package com.example.backend.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "authority")
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@ApiModel(description = "Authority model")
@Data
@ToString
@BatchSize(size = 10)
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authorities")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<People> peopleList;

    public Authority() {
    }

    public Authority(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
