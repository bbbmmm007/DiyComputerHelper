package com.zhny.computer.service;

import com.zhny.computer.entity.Knowledge;

import java.util.List;

public interface KnowledgeService {
    void addKnowledge(Integer amid,Knowledge knowledge);
    void deleteKnowledge(Integer amid,Integer knid);
    void updateKnowledge(Knowledge knowledge,Integer amid,String adminName,Integer knid);
    Knowledge showKnowledgeDetail(Integer knid);
    List<Knowledge> showAllKnowledge();
    List<Knowledge> showKnowledgeF(Integer ancestorId,Integer pageSize,Integer pageNumber);
    List<Knowledge> showAllKnowledgeF(Integer pageSize,Integer pageNumber);
    Integer countAllKnowledge();
    Integer countKnowledge(Integer ancestorId);
}
