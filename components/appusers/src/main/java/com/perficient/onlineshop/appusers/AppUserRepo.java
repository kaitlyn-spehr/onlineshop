package com.perficient.onlineshop.appusers;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepo extends CrudRepository<AppUser,Long>
{
    Optional<AppUser> findById(Long id);
    Iterable<AppUser> findAllByName(String name);
    Iterable<AppUser> findAllByEmail(String email);
}
