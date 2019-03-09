package com.thornchg.rkt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thornchg.rkt.entity.Paper;
import com.thornchg.rkt.entity.vo.PaperVo;
import com.thornchg.rkt.mapper.PaperMapper;
import com.thornchg.rkt.service.PaperService;
import org.springframework.stereotype.Service;

@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {


    @Override
    public IPage<PaperVo> list(Page<PaperVo> page, Paper paper) {
        return page.setRecords(baseMapper.findList(page,paper));
    }

    @Override
    public PaperVo getVoById(String id) {
        return baseMapper.findVoById(id);
    }
}
