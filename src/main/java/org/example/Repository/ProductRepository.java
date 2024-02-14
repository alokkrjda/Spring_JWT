package org.example.Repository;

import org.example.Model.Product;
import org.example.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p FROM Product p where p.productname like :productname and p.productdes like :productdes")
    List<Product> getProductByAnyField(String productname, String productdes);

    @Query(value = "SELECT p FROM Product p where p.productname like :productname and p.productprice = :productprice and p.productdes like :productdes")
    List<Product> getProductByAnyField(String productname, Integer productprice, String productdes);
}
