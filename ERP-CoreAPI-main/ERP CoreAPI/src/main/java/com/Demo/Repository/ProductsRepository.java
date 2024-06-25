package com.Demo.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.Products.Entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{
    
    Collection<Products> findAllByStatsTrue();
}
