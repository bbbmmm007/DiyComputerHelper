package com.zhny.computer.service.impl;


import com.zhny.computer.entity.Collection;
import com.zhny.computer.entity.Product;
import com.zhny.computer.entity.User;
import com.zhny.computer.mapper.CollectionMapper;
import com.zhny.computer.mapper.ProductMapper;
import com.zhny.computer.mapper.UserMapper;
import com.zhny.computer.service.CollectionService;
import com.zhny.computer.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;
    //添加商品进收藏
    @Override
    public void addCollection(Integer uid,Integer id,Collection collection) {
        User result=userMapper.findByUid(uid);
        if(result==null){
            throw new UserNotFoundException("用户信息不存在");
        }
        Product product=productMapper.findById(id);
        if(product==null){
            throw new ProductNotFoundException("商品信息不存在");
        }
        Integer resultCount=collectionMapper.checkCollection(id,uid);
        if(resultCount>=1){
            throw new InsertException("添加商品失败，商品已进收藏，请勿重复添加");
        }

        collection.setUid(result.getUid());
        collection.setChildId(product.getChildId());
        collection.setId(id);
        collection.setImage(product.getImage());
        collection.setPrice(product.getPrice());
        collection.setItemType(product.getItemType());
        collection.setCreatedTime(new Date());

        Integer rows=collectionMapper.addCollection(collection);
        if(rows!=1){
            throw new InsertException("插入数据时发生错误");
        }
    }

    //移除收藏商品
    @Override
    public void deleteCollection(Integer uid,Integer id) {
        User result=userMapper.findByUid(uid);
        if(result==null){
            throw new AccessDeniedException("非法数据访问");
        }

        Integer rows = collectionMapper.deleteCollection(id,uid);
        if(rows!=1){
            throw new InsertException("插入数据时发生错误");
        }

    }
    //展示收藏列表
    @Override
    public List<Collection> showCollection(Integer uid) {
        User result=userMapper.findByUid(uid);
        if(result==null){
            throw new AccessDeniedException("非法数据访问");
        }
        List<Collection> list = collectionMapper.showCollection(uid);

        return list;
    }
    //一键清空收藏列表
    @Override
    public void clearCollection(Integer uid) {
        User result=userMapper.findByUid(uid);
        if(result==null){
            throw new AccessDeniedException("非法数据访问");
        }
        collectionMapper.clearCollection(uid);
    }
}
