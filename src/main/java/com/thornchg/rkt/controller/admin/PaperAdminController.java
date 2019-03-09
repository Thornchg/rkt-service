package com.thornchg.rkt.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thornchg.rkt.entity.Paper;
import com.thornchg.rkt.entity.Question;
import com.thornchg.rkt.entity.vo.ChoiceQuestionVo;
import com.thornchg.rkt.entity.vo.PaperVo;
import com.thornchg.rkt.entity.vo.UserVo;
import com.thornchg.rkt.service.PaperService;
import com.thornchg.rkt.service.QuestionService;
import com.thornchg.rkt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/admin/paper")
public class PaperAdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private PaperService paperService;

    @PostMapping("/addPaper")
    @SuppressWarnings("unchecked")
    public ResponseEntity addPaper(@RequestBody PaperVo paperVo) {
        UserVo userVo = userService.getVoByEmail("Thornchg@163.com");
//        System.out.println(paperVo);
        Paper paper = paperVo.toPaper();
        paper.setCreateTime(new Date());
        paper.setCreatorId(userVo.getId());
        paper.setStatus(0);
        List<String> questionIds = (List<String>) paperVo.getQuestions();
        if (questionIds.size()>0) {
//            List<Question> questions = (List<Question>) questionService.listByIds(questionIds);
            List<ChoiceQuestionVo> questionVos = questionService.listVoByIds(questionIds);
            for (ChoiceQuestionVo questionVo:questionVos){
                questionVo.setSelects(JSONArray.parseArray((String) questionVo.getSelects()));
            }
//            paper.setQuestions(JSON.toJSONString(questions));
//            System.out.println(JSON.toJSONString(questionVos));
            paper.setQuestions(JSON.toJSONString(questionVos));
        }
        if (paperService.save(paper)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("list")
    public ResponseEntity list(Paper paper) {
        IPage<PaperVo> list = paperService.list(new Page<>(), paper);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("updateStatus")
    public ResponseEntity updateStatus(@RequestBody Paper paper) {
        UpdateWrapper<Paper> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq(true,"id",paper.getId());
        updateWrapper.set("status",paper.getStatus());
        if (paperService.update(updateWrapper)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("update")
    public ResponseEntity update(@RequestBody Paper paper) {
        UpdateWrapper<Paper> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq(true,"id",paper.getId());
        updateWrapper.set("status",paper.getStatus());
        if (paperService.update(updateWrapper)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getPaper(@PathVariable String id) {
        Paper paper = paperService.getById(id);
        if (paper!=null){
            return new ResponseEntity<>(paper,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody String id){
        if (paperService.removeById(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
