package com.Api.Repository;

import com.Api.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    //Search by product name
    //Product names assumed to be unique
    Optional<Product> findByName(String name);
}
