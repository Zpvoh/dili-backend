package com.example.dili;

import com.example.dili.model.Item;
import com.example.dili.model.Store;
import com.example.dili.model.StoreRegisterResponse;
import com.example.dili.model.User;
import com.example.dili.service.ItemService;
import com.example.dili.service.StoreService;
import com.example.dili.service.UserService;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DiliApplicationTests {

    @Autowired
    ItemService itemService;

    @Autowired
    StoreService storeService;

    @Autowired
    UserService userService;

    static int userID = -1;
    static int storeID = -1;
    static int itemID = -1;

    @Test
    void contextLoads() {

    }

    @Order(1)
    @Test
    void testUserRegister(){
        User user = new User();
        user.setUsername("test");
        user.setEmail("aaa@bbb.com");
        user.setPassword("hhhhh222");
        assertTrue(userService.registerUser(user).isSucceed());
    }

    @Order(2)
    @Test
    void testUserLogin(){
        User user = new User();
        user.setEmail("aaa@bbb.com");
        user.setPassword("hhhhh222");
        Object realUser = userService.loginUser(user);
        if(realUser instanceof User){
            userID = ((User)realUser).getID();
        }
        assertTrue(realUser instanceof User);
    }

    @Order(3)
    @Test
    void testStoreRegister(){
        Store store = new Store();
        store.setStoreName("test store");
        store.setStoreAddr("xxxx");
        store.setPassword("222hhhhh");
        StoreRegisterResponse response = storeService.registerStore(store);
        storeID = response.getId();
        assertTrue(response.getStatus().isSucceed());
    }

    @Order(4)
    @Test
    void testStoreLogin(){
        Store store = new Store();
        store.setID(storeID);
        store.setPassword("222hhhhh");
        Object realStore = storeService.loginStore(store);
        assertTrue(realStore instanceof Store);
    }

    @Order(5)
    @Test
    void testItemPublish(){
        Item item = new Item();
        item.setStoreID(storeID);
        item.setItemName("fish");
        item.setImage("");
        item.setPrice(3.45);
        item.setDescription("delicious");
        assertTrue(itemService.publishItem(item).isSucceed());
    }

    @Order(6)
    @Test
    void testItemList(){
        List<Item> items = itemService.getItemList(storeID);
        if(items!=null && items.size()>0){
            itemID = items.get(0).getID();
        }
        assert items != null;
        assertTrue(items.size()>0 && items.get(0).getItemName().equals("fish"));
    }

    @Order(7)
    @Test
    void testItemInfo(){
        Item getInfoItem = itemService.getItemInfo(itemID);
        assertEquals("fish", getInfoItem.getItemName());
    }

    @Order(8)
    @Test
    void testItemModify(){
        Item item = itemService.getItemInfo(itemID);
        item.setDescription("actually not so delicious");
        assertTrue(itemService.modifyItem(item).isSucceed());
        item = itemService.getItemInfo(itemID);
        assertEquals("actually not so delicious", item.getDescription());
    }

    @Order(9)
    @Test
    void testItemRemove(){
        Item item = new Item();
        item.setID(itemID);
        assertTrue(itemService.removeItem(item).isSucceed());
        assertNull(itemService.getItemInfo(itemID));
    }

    @AfterAll
    void after(){
        userService.removeUser(userID);
        storeService.removeStore(storeID);
        Item item = new Item();
        item.setID(itemID);
        itemService.removeItem(item);
    }

}
