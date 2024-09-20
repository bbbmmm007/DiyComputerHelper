package com.zhny.computer.service;

import com.zhny.computer.entity.Collection;

import java.util.List;

public interface CollectionService {
    //添加商品进入收藏
    void addCollection(Integer uid,Integer id,Collection collection);
    //移除收藏商品
    void deleteCollection(Integer uid,Integer id);
    //展示收藏商品
    List<Collection> showCollection(Integer uid);
    //清空收藏商品
    void clearCollection(Integer uid);

}
