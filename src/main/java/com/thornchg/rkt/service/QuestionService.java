package com.thornchg.rkt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thornchg.rkt.entity.Question;
import com.thornchg.rkt.entity.SubjectKnowledge;
import com.thornchg.rkt.entity.vo.ChoiceQuestionVo;
import javafx.scene.control.Pagination;

import java.util.List;

public interface QuestionService extends IService<Question> {
    IPage<ChoiceQuestionVo> getList(Page<ChoiceQuestionVo> page,Question question);
    IPage<ChoiceQuestionVo> getListBySubjectKnowledge(Page<ChoiceQuestionVo> page, SubjectKnowledge subjectKnowledge);
    List<ChoiceQuestionVo> listVoByIds(List<String> ids);
    ChoiceQuestionVo getVoById(String id);
}
