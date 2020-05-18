package com.example.dili.controller;

import com.example.dili.model.Item;
import com.example.dili.model.ResponseStatus;
import com.example.dili.model.Store;
import com.example.dili.model.StoreRegisterResponse;
import com.example.dili.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/itemPublish", method = RequestMethod.POST)
    public ResponseStatus publishItem(@RequestBody Item itemInfo){
        return itemService.publishItem(itemInfo);
    }

    @RequestMapping(value = "/itemModify", method = RequestMethod.POST)
    public ResponseStatus modifyItem(@RequestBody Item itemInfo){
        return itemService.modifyItem(itemInfo);
    }

    @RequestMapping(value = "/itemRemove", method = RequestMethod.POST)
    public ResponseStatus removeItem(@RequestBody Item itemInfo){
        return itemService.removeItem(itemInfo);
    }

    @RequestMapping(value = "/itemInfo/{id}", method = RequestMethod.GET)
    public Item getItemInfo(@PathVariable int id){
        return itemService.getItemInfo(id);
    }

    @RequestMapping(value = "/itemlist/{storeID}", method = RequestMethod.GET)
    public List<Item> getAllItems(@PathVariable int storeID){
        return itemService.getItemList(storeID);
    }
}
