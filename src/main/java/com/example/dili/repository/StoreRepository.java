package com.example.dili.repository;

import com.example.dili.model.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {
    @Query(value = "select * from Store where store_name=?1", nativeQuery = true)
    Optional<Store> findStoreByStoreName(String name);
}
