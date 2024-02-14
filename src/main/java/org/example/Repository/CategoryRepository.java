package org.example.Repository;

import org.example.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT c FROM Category c WHERE c.categoryname like :categoryname AND c.categorydes like :categorydes")
    List<Category> findCategoryByAnyField(String categoryname, String categorydes);
}
