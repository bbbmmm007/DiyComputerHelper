package com.zhny.computer.service;

import com.zhny.computer.entity.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class CollectionSvericeTest {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private ProductService productService;
    @Test
    public void addCollection() {
        Collection collection = new Collection();
        collectionService.addCollection(17,100000466,collection);
    }
    @Test
    public void deleteCollection() {
        collectionService.deleteCollection(331,100000465);
    }


}
