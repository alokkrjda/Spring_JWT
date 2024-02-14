package org.example.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ecommerce-category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category")
    private int categoryid;

    @Column(name = "categoryname")
    private String categoryname;

    @Column(name = "categorydes")
    private String categorydes;
}
