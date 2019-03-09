package com.thornchg.rkt.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.thornchg.rkt.entity.Subject;
import com.thornchg.rkt.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class SubjectAdminController {
    @Autowired
    private SubjectService subjectService;
    @RequestMapping("/subject/list")
    public ResponseEntity<List<Subject>> list(Subject subject){
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>(subject);
        queryWrapper.orderByDesc("level");
        List<Subject> list = subjectService.list(queryWrapper);
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
