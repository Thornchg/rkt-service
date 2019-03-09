package com.thornchg.rkt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thornchg.rkt.entity.Subject;

import java.util.List;

public interface SubjectService extends IService<Subject> {
    List<Subject> list(Subject subject);
}
