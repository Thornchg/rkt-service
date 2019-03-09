package com.thornchg.rkt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thornchg.rkt.entity.Knowledge;
import com.thornchg.rkt.entity.SubjectKnowledge;
import com.thornchg.rkt.entity.vo.KnowledgeVo;

import java.util.List;

public interface KnowledgeService extends IService<Knowledge> {
    List<KnowledgeVo> listBySubjectKnowledge(SubjectKnowledge subjectKnowledge);
}
