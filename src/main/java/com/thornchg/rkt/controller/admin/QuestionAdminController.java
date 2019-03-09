package com.thornchg.rkt.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thornchg.rkt.entity.Question;
import com.thornchg.rkt.entity.SubjectKnowledge;
import com.thornchg.rkt.entity.vo.ChoiceQuestionVo;
import com.thornchg.rkt.entity.vo.UserVo;
import com.thornchg.rkt.service.QuestionService;
import com.thornchg.rkt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin")
public class QuestionAdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @PostMapping("/question/addChoiceQuestion")
    public ResponseEntity addChoiceQuestion(@RequestBody ChoiceQuestionVo choiceQuestionVo){
        UserVo userVo = userService.getVoByEmail("Thornchg@163.com");
        Question question=choiceQuestionVo.toQuestion();
        question.setQuestionType(1);
        question.setCreateTime(new Date());
        question.setCreatorId(userVo.getId());
        questionService.save(question);
        System.out.println(question);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/question/addCaseQuestion")
    public ResponseEntity addCaseQuestion(@RequestBody Question question){
        UserVo userVo = userService.getVoByEmail("Thornchg@163.com");
        question.setQuestionType(2);
        question.setCreateTime(new Date());
        question.setCreatorId(userVo.getId());
        questionService.save(question);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/question/addThesisQuestion")
    public ResponseEntity addThesisQuestion(@RequestBody Question question){
        UserVo userVo = userService.getVoByEmail("Thornchg@163.com");
        question.setQuestionType(3);
        question.setCreateTime(new Date());
        question.setCreatorId(userVo.getId());
        questionService.save(question);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("question/list")
    public ResponseEntity list(Question question){
//        IPage<Question> page = questionService.page(new Page<>(1, 1));
        IPage<ChoiceQuestionVo> page = questionService.getList(new Page<>(1, 10),question);
        System.out.println(page.getTotal());
        System.out.println(page);
        return new ResponseEntity<>(page,HttpStatus.OK);
    }
    @PostMapping("question/delete")
    public ResponseEntity delete(@RequestBody Question question){
        if(questionService.removeById(question.getId())){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("question/listbySubjectKnowledge")
    public ResponseEntity list(SubjectKnowledge subjectKnowledge){
        IPage<ChoiceQuestionVo> page = questionService.getListBySubjectKnowledge(new Page<>(), subjectKnowledge);
        System.out.println(page.getRecords());
        return new ResponseEntity<>(page,HttpStatus.OK);
    }

}
