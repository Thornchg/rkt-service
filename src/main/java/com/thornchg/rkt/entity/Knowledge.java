package com.thornchg.rkt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_knowledge")
public class Knowledge {
    private Integer id;
    private String name;
    private String code;
}
