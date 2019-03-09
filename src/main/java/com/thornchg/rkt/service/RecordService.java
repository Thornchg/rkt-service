package com.thornchg.rkt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thornchg.rkt.entity.Paper;
import com.thornchg.rkt.entity.Record;

import java.util.List;

public interface RecordService extends IService<Record> {
    List<Record> listbyPaper(String userId,Paper paper);
}
