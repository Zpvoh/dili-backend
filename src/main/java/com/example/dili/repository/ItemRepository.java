package com.example.dili.repository;

import com.example.dili.model.Item;
import com.example.dili.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
    @Query(value = "select * from Item where store_id=?1", nativeQuery = true)
    List<Item> findAllByStoreID(int storeID);

    @Query(value = "select * from Item where item_name=?1", nativeQuery = true)
    Item findByItemName(String itemName);
}
