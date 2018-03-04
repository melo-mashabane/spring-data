package com.example.repository.repository.repository;

import com.example.repository.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mpumelelomashabane on 20/11/2017.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByType(String type);
    List<Product> findByDescriptionAndCategory(String description, String category);
    List<Product> findByCategoryAndNameIn(String category, List<String> name);

}
