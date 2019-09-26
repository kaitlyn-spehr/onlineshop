package com.perficient.onlineshop.transactions;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransRepo extends CrudRepository<Transaction,Long>
{
    Optional<Transaction> findById(Long id);
}
