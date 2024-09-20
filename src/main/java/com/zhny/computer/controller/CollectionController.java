package com.zhny.computer.controller;

import com.zhny.computer.entity.Collection;
import com.zhny.computer.service.CollectionService;
import com.zhny.computer.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController extends BaseController{
    @Autowired
    private CollectionService collectionService;
    //加入收藏
    @RequestMapping("/add_collection")
    public JsonResult<Void> addCollection(HttpSession session,Integer id, Collection collection){
        Integer uid =getUidFromSession(session);
        collectionService.addCollection(uid,id,collection);
        return new JsonResult<>(SUCCESS);
    }
    //移除收藏
    @RequestMapping("/delete_collection")
    public JsonResult<Void> deleteCollection(HttpSession session, Integer id){
        Integer uid =getUidFromSession(session);
        collectionService.deleteCollection(uid,id);
        return new JsonResult<>(SUCCESS);
    }
    //展示收藏列表
    @RequestMapping("/show_collection")
    public JsonResult<List<Collection>> showCollection(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Collection> collections = collectionService.showCollection(uid);
        return new JsonResult<>(SUCCESS,collections);
    }
    //清空收藏列表
    @RequestMapping("/clear_collection")
    public JsonResult<Void> clearCollection(HttpSession session){
        Integer uid = getUidFromSession(session);
        collectionService.clearCollection(uid);
        return new JsonResult<>(SUCCESS);
    }
}
