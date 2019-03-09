package com.thornchg.rkt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thornchg.rkt.entity.Paper;
import com.thornchg.rkt.entity.Record;
import com.thornchg.rkt.mapper.RecordMapper;
import com.thornchg.rkt.service.RecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {
    @Override
    public List<Record> listbyPaper(String userId,Paper paper) {
        return baseMapper.selectListByPaper(userId,paper);
    }
}
