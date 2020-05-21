package com.example.dili.controller;

import com.example.dili.model.ResponseStatus;
import com.example.dili.model.Store;
import com.example.dili.model.StoreRegisterResponse;
import com.example.dili.model.User;
import com.example.dili.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class StoreController {
    @Autowired
    StoreService storeService;

    @RequestMapping(value = "/restRegister", method = RequestMethod.POST)
    public StoreRegisterResponse StoreRegister(@RequestBody Store storeInfo){
        return storeService.registerStore(storeInfo);
    }

    @RequestMapping(value = "/restLogin", method = RequestMethod.POST)
    public Object StoreLogin(@RequestBody Store storeInfo){
        return storeService.loginStore(storeInfo);
    }
}
