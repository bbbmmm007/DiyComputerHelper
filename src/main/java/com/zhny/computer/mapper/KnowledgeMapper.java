package com.zhny.computer.mapper;

import com.zhny.computer.entity.Knowledge;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface KnowledgeMapper {
    List<Knowledge> showKnowledge(@Param("ancestorId") Integer ancestorId);

    Integer addKnowledge(Knowledge knowledge);

    Integer updateKnowledge(
            @Param("topic") String topic,
            @Param("content") String content,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime,
            @Param("knid") Integer knid
    );


    Integer deleteKnowledge(Integer knid);

    String showAnName(@Param("ancestorId") Integer ancestorId);

    Knowledge showKnowledgeDetail(Integer knid);

    List<Knowledge> showAllKnowledge();

    List<Knowledge> showAllKnowledgeF(@Param("pageSize") Integer pageSize, @Param("offset") Integer offset);
    List<Knowledge> showKnowledgeF(@Param("ancestorId") Integer ancestorId, @Param("pageSize") Integer pageSize,@Param("offset") Integer offset);

    Integer countAllKnowledge();
    Integer countKnowledge(@Param("ancestorId") Integer ancestorId);



}
