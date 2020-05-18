package com.example.dili.service;

import com.example.dili.model.ResponseStatus;
import com.example.dili.model.Store;
import com.example.dili.model.StoreRegisterResponse;
import com.example.dili.model.User;
import com.example.dili.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public StoreRegisterResponse registerStore(Store storeInfo){
        if (storeRepository.existsById(storeInfo.getID())) {
            return new StoreRegisterResponse(-1, new ResponseStatus(false, "Same ID has existed."));
        } else {
            Store store = storeRepository.save(storeInfo);
            if (store == null) {
                return new StoreRegisterResponse(-1, new ResponseStatus(false, "Save failed."));
            } else {
                return new StoreRegisterResponse(store.getID(), new ResponseStatus(true, "Succeed."));
            }
        }
    }

    public Object loginStore(Store storeInfo) {
        Optional<Store> realStoreInfo = storeRepository.findById(storeInfo.getID());

        if (realStoreInfo.isPresent()) {
            if(realStoreInfo.get().getPassword().equals(storeInfo.getPassword())) {
                return realStoreInfo.get();
            }else{
                return new ResponseStatus(false, "ID or Password is wrong.");
            }
        } else {
            return new ResponseStatus(false, "Account do not exist");
        }
    }
}
