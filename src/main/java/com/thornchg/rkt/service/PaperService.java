package com.thornchg.rkt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thornchg.rkt.entity.Paper;
import com.thornchg.rkt.entity.vo.PaperVo;

public interface PaperService extends IService<Paper> {
    IPage<PaperVo> list(Page<PaperVo> page,Paper paper);
    PaperVo getVoById(String id);
}
