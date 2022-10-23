package com.example.springoauth2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    private Float price;

    private String description;

    public Product() {}
}
