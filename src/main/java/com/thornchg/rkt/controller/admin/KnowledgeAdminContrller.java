package com.thornchg.rkt.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thornchg.rkt.entity.Knowledge;
import com.thornchg.rkt.entity.SubjectKnowledge;
import com.thornchg.rkt.entity.vo.KnowledgeVo;
import com.thornchg.rkt.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class KnowledgeAdminContrller {
    @Autowired
    private KnowledgeService knowledgeService;
    @RequestMapping("/knowledge/list")
    public ResponseEntity<List<Knowledge>> list(Knowledge knowledge){
        QueryWrapper<Knowledge> queryWrapper = new QueryWrapper<>(knowledge);
        List<Knowledge> list = knowledgeService.list(queryWrapper);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/knowledge/listBySubjectKnowledge")
    public ResponseEntity listBySubjectKnowledge(SubjectKnowledge subjectKnowledge){
        List<KnowledgeVo> knowledgeVos = knowledgeService.listBySubjectKnowledge(subjectKnowledge);
        return new ResponseEntity<>(knowledgeVos, HttpStatus.OK);
    }
}
