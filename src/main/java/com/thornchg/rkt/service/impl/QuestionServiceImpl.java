package com.thornchg.rkt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thornchg.rkt.entity.Question;
import com.thornchg.rkt.entity.SubjectKnowledge;
import com.thornchg.rkt.entity.vo.ChoiceQuestionVo;
import com.thornchg.rkt.mapper.QuestionMapper;
import com.thornchg.rkt.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Override
    public IPage<ChoiceQuestionVo> getList(Page<ChoiceQuestionVo> page,Question question) {
        return page.setRecords(baseMapper.findList(page,question));
    }

    @Override
    public IPage<ChoiceQuestionVo> getListBySubjectKnowledge(Page<ChoiceQuestionVo> page, SubjectKnowledge subjectKnowledge) {
        return page.setRecords(baseMapper.selectBySubjectKnowledge(page,subjectKnowledge));
    }

    @Override
    public List<ChoiceQuestionVo> listVoByIds(List<String> ids) {
        List<ChoiceQuestionVo> questionVos=new ArrayList<>();
        for (String id : ids){
            questionVos.add(this.getVoById(id));
        }
        return questionVos;
    }

    @Override
    public ChoiceQuestionVo getVoById(String id) {
        return baseMapper.selectVoById(id);
    }
}
