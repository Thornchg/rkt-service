package com.thornchg.rkt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.thornchg.rkt.entity.Knowledge;
import com.thornchg.rkt.entity.SubjectKnowledge;
import com.thornchg.rkt.entity.vo.KnowledgeVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface KnowledgeMapper extends BaseMapper<Knowledge> {
    List<KnowledgeVo> selectBySubjectKnowledge(SubjectKnowledge subjectKnowledge);
}
