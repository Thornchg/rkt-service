package com.thornchg.rkt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.thornchg.rkt.entity.Question;
import com.thornchg.rkt.entity.SubjectKnowledge;
import com.thornchg.rkt.entity.vo.ChoiceQuestionVo;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QuestionMapper extends BaseMapper<Question> {
    List<ChoiceQuestionVo> findList(IPage<ChoiceQuestionVo> page,Question question);
    List<ChoiceQuestionVo> selectBySubjectKnowledge(IPage<ChoiceQuestionVo> page, SubjectKnowledge subjectKnowledge);
    ChoiceQuestionVo selectVoById(String id);
}
