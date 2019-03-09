package com.thornchg.rkt.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class KnowledgeVo {
    private Integer id;
    private String name;
    private String code;
    @TableField("subject_id")
    private Integer SubjectId;
    @TableField("question_type")
    private Integer questionType;
}
