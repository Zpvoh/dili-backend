package com.example.dili.service;

import com.example.dili.model.Item;
import com.example.dili.model.ResponseStatus;
import com.example.dili.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItemList(int storeID){
        return itemRepository.findAllByStoreID(storeID);
    }

    public Item getItemInfo(int itemID){
        return itemRepository.findById(itemID).orElse(null);
    }

    public ResponseStatus publishItem(Item item){
        if(itemRepository.findByItemName(item.getItemName())==null){
            if(itemRepository.save(item)!=null){
                return new ResponseStatus(true, "Succeed.");
            }else{
                return new ResponseStatus(false, "Publishing failed.");
            }
        }else{
            return new ResponseStatus(false, "This item has existed.");
        }
    }

    public ResponseStatus modifyItem(Item item){
        if(itemRepository.save(item)!=null){
            return new ResponseStatus(true, "Succeed.");
        }else{
            return new ResponseStatus(false, "Modification failed.");
        }
    }

    public ResponseStatus removeItem(Item item){
        itemRepository.deleteById(item.getID());
        return new ResponseStatus(true, "Succeed.");
    }
}
