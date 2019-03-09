package com.thornchg.rkt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thornchg.rkt.entity.Knowledge;
import com.thornchg.rkt.entity.SubjectKnowledge;
import com.thornchg.rkt.entity.vo.KnowledgeVo;
import com.thornchg.rkt.mapper.KnowledgeMapper;
import com.thornchg.rkt.service.KnowledgeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeServiceImpl extends ServiceImpl<KnowledgeMapper, Knowledge> implements KnowledgeService {
    @Override
    public List<KnowledgeVo> listBySubjectKnowledge(SubjectKnowledge subjectKnowledge) {
        return baseMapper.selectBySubjectKnowledge(subjectKnowledge);
    }
}
