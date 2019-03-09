package com.thornchg.rkt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thornchg.rkt.entity.Subject;
import com.thornchg.rkt.mapper.SubjectMapper;
import com.thornchg.rkt.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Override
    public List<Subject> list(Subject subject) {
        return subjectMapper.selectList(new QueryWrapper<>(subject));
    }
}
