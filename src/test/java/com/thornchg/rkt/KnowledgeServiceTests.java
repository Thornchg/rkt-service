package com.thornchg.rkt;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thornchg.rkt.entity.SubjectKnowledge;
import com.thornchg.rkt.entity.vo.KnowledgeVo;
import com.thornchg.rkt.service.KnowledgeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KnowledgeServiceTests {
    @Autowired
    private KnowledgeService knowledgeService;
    @Test
    public void listBySubjectKnowledgeTest(){
        SubjectKnowledge subjectKnowledge=new SubjectKnowledge();
        subjectKnowledge.setSubjectId(7);
        subjectKnowledge.setQuestionType(1);
        List<KnowledgeVo> knowledgeVos = knowledgeService.listBySubjectKnowledge(subjectKnowledge);
        System.out.println(knowledgeVos);

    }
}
