package com.perficient.onlineshop.products;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepo extends CrudRepository<Product,Long>
{
    Optional<Product> findById(Long id);
}
