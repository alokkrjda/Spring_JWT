package org.example.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ecommerce-product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "productid")
    private int productid;

    @Column(name = "productname")
    private String productname;

    @Column(name = "productprice")
    private Integer productprice;

    @Column(name = "productdes")
    private String productdes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryid")
    private Category category;
}
