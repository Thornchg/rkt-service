package com.thornchg.rkt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.thornchg.rkt.entity.Paper;
import com.thornchg.rkt.entity.vo.PaperVo;
import javafx.scene.control.Pagination;

import java.util.List;

public interface PaperMapper extends BaseMapper<Paper> {
    List<PaperVo> findList(IPage<PaperVo> page, Paper paper);
    PaperVo findVoById(String id);
}
