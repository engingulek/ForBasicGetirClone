package com.example.market.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name= "product")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "imageurl")
    private String imageUrl;


    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price;

    @Column(name = "about_product")
    private String aboutProduct;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;



}
