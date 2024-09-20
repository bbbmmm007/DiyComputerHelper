package com.zhny.computer.mapper;


import com.zhny.computer.entity.Knowledge;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@SpringBootTest //表示当前类是一个测试类
@RunWith(SpringRunner.class)
public class KnowledgeMapperTest {
    @Autowired
    private KnowledgeMapper knowledgeMapper;
    @Test
    public void insert() {
        Knowledge knowledge = new Knowledge();
        knowledge.setTopic("5555");
        knowledge.setContent("55555555");


        knowledgeMapper.updateKnowledge(knowledge.getTopic(),knowledge.getContent(),"bbbmmm",new Date(),1);

    }
    @Test
    public void show(){
        knowledgeMapper.showAllKnowledgeF(10,1);
        System.out.println(knowledgeMapper.showAllKnowledgeF(10,1));
    }


}
