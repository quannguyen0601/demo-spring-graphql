package com.quan.graphql.demo.graphql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Entity
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "type", nullable = false)

    private String type;

    @Column(name = "model_code", nullable = false)

    private String modelCode;

    @Column(name = "brand_name")

    private String brandName;

    @Column(name = "launch_date")

    private LocalDate launchDate;

    private transient  String formattedDate;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="owner_id")
    @JsonIgnore
    private Owner owner;

    // Getter and setter

    public String getFormattedDate() {

        return getLaunchDate().toString();

    }

}