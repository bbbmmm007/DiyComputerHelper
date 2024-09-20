package com.zhny.computer.controller;


import com.zhny.computer.entity.Knowledge;
import com.zhny.computer.service.KnowledgeService;
import com.zhny.computer.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("knowledges")
public class KnowledgeController extends BaseController{
    @Autowired
    private KnowledgeService knowledgeService;
    //增加词条
    @RequestMapping("add_knowledge")
    public JsonResult<Void> addKnowledge(HttpSession session,Knowledge knowledge){
        Integer amid = getAmidFromSession(session);
        knowledgeService.addKnowledge(amid,knowledge);
        return new JsonResult<>(SUCCESS);
    }
    //删除词条
    @RequestMapping("delete_knowledge/{knid}/")
    public JsonResult<Void> deleteKnowledge(HttpSession session,@PathVariable("knid") Integer knid){
        Integer amid = getAmidFromSession(session);
        knowledgeService.deleteKnowledge(amid,knid);
        return new JsonResult<>(SUCCESS);
    }
    //修改词条
    @RequestMapping("update_knowledge/{knid}")
    public JsonResult<Void> updateKnowledge(HttpSession session,Knowledge knowledge,@PathVariable("knid") Integer knid){
        Integer amid = getAmidFromSession(session);
        String adminName = getAdminNameFromSession(session);
        knowledgeService.updateKnowledge(knowledge,amid,adminName,knid);
        return new JsonResult<>(SUCCESS);
    }
    //展示词条的详细信息
    @RequestMapping("show_detail_knowledge")
    public JsonResult<Knowledge> showDetailKnowledge(Integer knid){
        Knowledge knowledge = knowledgeService.showKnowledgeDetail(knid);
        return new JsonResult<>(SUCCESS,knowledge);
    }
    //展示所有词条
    @RequestMapping("show_all_knowledge")
    public JsonResult<List<Knowledge>> showAllKnowledge(){
        List<Knowledge> knowledgeList = knowledgeService.showAllKnowledge();
        return new JsonResult<>(SUCCESS,knowledgeList);
    }

    //分页展示各个板块词条
    @RequestMapping("/show_knowledgeF/{ancestorId}/{pageNumber}/{pageSize}")
    public JsonResult<List<Knowledge>> showKnowledgeF(@PathVariable("ancestorId") Integer ancestorId,@PathVariable("pageNumber") Integer pageNumber,@PathVariable("pageSize") Integer pageSize){
        List<Knowledge> knowledgeList = knowledgeService.showKnowledgeF(ancestorId,pageNumber,pageSize);
        return new JsonResult<>(SUCCESS,knowledgeList);
    }
    //分页展示所有词条
    @RequestMapping("show_all_knowledgeF/{pageNumber}/{pageSize}")
    public JsonResult<List<Knowledge>> showAllKnowledgeF(@PathVariable("pageNumber") Integer pageNumber,@PathVariable("pageSize") Integer pageSize){
        List<Knowledge> knowledgeList = knowledgeService.showAllKnowledgeF(pageNumber,pageSize);
        return new JsonResult<>(SUCCESS,knowledgeList);
    }
    //统计该板块词条数量
    @RequestMapping("/count_knowledge/{ancestorId}")
    public JsonResult<Integer> countKnowledge(@PathVariable("ancestorId") Integer ancestorId){
        Integer countKnowledge = knowledgeService.countKnowledge(ancestorId);
        return new JsonResult<>(SUCCESS,countKnowledge);
    }
    //统计所有词条数量
    @RequestMapping("/count_all_knowledge")
    public JsonResult<Integer> countKnowledge(){
        Integer countKnowledge = knowledgeService.countAllKnowledge();
        return new JsonResult<>(SUCCESS,countKnowledge);
    }





}
