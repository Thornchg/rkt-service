package com.thornchg.rkt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thornchg.rkt.entity.Paper;
import com.thornchg.rkt.entity.Record;

import java.util.List;

public interface RecordMapper extends BaseMapper<Record> {
    List<Record> selectListByPaper(String userId,Paper paper);
}
