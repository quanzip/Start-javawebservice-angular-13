package com.example.backend.entity;

import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.context.ApplicationEvent;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "people")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@ToString(exclude = "authorities")
@BatchSize(size = 10)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "pass_word")
    private String passWord;

    @Column(name = "p_number")
    private int pNumber;

    @Column(name = "is_actived")
    private int isActived;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "people_authority",
        joinColumns = @JoinColumn(name = "people_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
    )
    @EqualsAndHashCode.Exclude
    private Set<Authority> authorities;

}

