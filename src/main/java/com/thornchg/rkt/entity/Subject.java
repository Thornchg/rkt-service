package com.thornchg.rkt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_subject")
public class Subject {
    private Integer id;
    private String name;
    private Integer level;   //等级 1 初级 2 中级 3 高级
    private String code;

}
