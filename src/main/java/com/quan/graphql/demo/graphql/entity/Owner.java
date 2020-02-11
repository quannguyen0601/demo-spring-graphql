package com.quan.graphql.demo.graphql.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;

    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private Set<Vehicle> vehicles;


}
