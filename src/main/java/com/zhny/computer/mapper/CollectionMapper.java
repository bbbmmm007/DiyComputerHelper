package com.zhny.computer.mapper;

import com.zhny.computer.entity.Collection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMapper {
    //添加收藏
    Integer addCollection(Collection collection);
    //删除收藏
    Integer deleteCollection(@Param("id") Integer id,@Param("uid") Integer uid);
    //展示收藏
    List<Collection> showCollection(Integer uid);
    //清空收藏
    Integer clearCollection(Integer uid);
    //检查收藏的商品是否重复
    Integer checkCollection(@Param("id") Integer id, @Param("uid") Integer uid);

}
