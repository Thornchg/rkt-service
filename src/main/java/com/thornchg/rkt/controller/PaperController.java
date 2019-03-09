package com.thornchg.rkt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thornchg.rkt.entity.Paper;
import com.thornchg.rkt.entity.Record;
import com.thornchg.rkt.entity.User;
import com.thornchg.rkt.entity.vo.ChoiceQuestionVo;
import com.thornchg.rkt.entity.vo.ChoiceVo;
import com.thornchg.rkt.entity.vo.PaperVo;
import com.thornchg.rkt.entity.vo.RecordVo;
import com.thornchg.rkt.service.PaperService;
import com.thornchg.rkt.service.RecordService;
import com.thornchg.rkt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;
    @Autowired
    private UserService userService;
    @Autowired
    private RecordService recordService;

    @GetMapping("list")
    public ResponseEntity list(Paper paper) {
        paper.setStatus(1);
        IPage<PaperVo> list = paperService.list(new Page<>(), paper);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("createExamRecord")
    public ResponseEntity createExamRecord(@RequestBody Paper paper) {
        Paper paper1 = paperService.getById(paper.getId());
        if (paper1 != null) {
            User user = userService.getByEmail("thornchg@163.com");
            Record record = new Record();
            record.setStatus(0);
            record.setUserId(user.getId());
            record.setPaperId(paper1.getId());
            record.setPaper(JSON.toJSONString(paper1));
            record.setCreateTime(new Date());
            record.setLimitTimeStamp((long) (paper1.getTime() * 60 * 1000));
            if (recordService.save(record)) {
                return new ResponseEntity<>(record.getId(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/getPaperByRecord")
    public ResponseEntity getPaperByRecord(@RequestBody String recordId) {
        Record record1 = recordService.getById(recordId);
        if (record1 == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        PaperVo paperVo = paperService.getVoById(record1.getPaperId());
        return new ResponseEntity<>(paperVo, HttpStatus.OK);
    }

    @PostMapping("/submitPaper")
    @SuppressWarnings("unchecked")
    public ResponseEntity submitPaper(@RequestBody RecordVo recordVo) {
        Record record = recordService.getById(recordVo.getId());
        String paperVoJson= JSONObject.toJSONString(recordVo.getPaper());
        PaperVo paperVo=JSON.parseObject(paperVoJson,PaperVo.class);
//        System.out.println(recordVo);

//        System.out.println(paperVo.getQuestions().toString());
        String questionsJson = JSONArray.toJSONString(paperVo.getQuestions());
//        System.out.println(questionsJson);
        int score = 0;
        List<ChoiceQuestionVo> questionVos = JSON.parseArray(questionsJson, ChoiceQuestionVo.class);
        if (paperVo.getQuestionType() == 1) { //为综合知识卷
            for (ChoiceQuestionVo questionVo : questionVos) {
                questionVo.setSelects(JSON.parseArray(questionVo.getSelects().toString(), ChoiceVo.class));
            }
            for (ChoiceQuestionVo questionVo : questionVos) {
//                questionVo.getSelects()
                for (ChoiceVo choiceVo : (List<ChoiceVo>) questionVo.getSelects()) {
                    if (choiceVo.getAnswer()!=null&&choiceVo.getKey().equals(choiceVo.getAnswer())){
                        score+=1;
                        choiceVo.setResult(1);
                    }else {
                        choiceVo.setResult(0);
                    }
                }
            }
            record.setScore(score);
            record.setStatus(2);
        }else {       // 为案例或论文卷时
            record.setStatus(1);
        }

        paperVo.setQuestions(questionVos);
        record.setUsedTime(recordVo.getUsedTime());
//        record.setStatus(1);
        record.setSubmitTime(new Date());
        record.setPaper(JSON.toJSONString(paperVo));
        if(recordService.updateById(record)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/result/{id}")
    public ResponseEntity getExamResult(@PathVariable String id){
        Record record = recordService.getById(id);
        if (record!=null){
            return new ResponseEntity<>(record,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/record/list")
    public ResponseEntity getRecordList(Paper paper){
        User user = userService.getByEmail("thornchg@163.com");
        List<Record> records=recordService.listbyPaper(user.getId(),paper);
        System.out.println(records);
        return new ResponseEntity<>(records,HttpStatus.OK);
    }
}
