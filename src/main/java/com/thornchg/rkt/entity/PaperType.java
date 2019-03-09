package com.thornchg.rkt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_paper_type")
public class PaperType {
    private Integer id;
    private String name;
    private String code;
}
