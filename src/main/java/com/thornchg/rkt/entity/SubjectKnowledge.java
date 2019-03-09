package com.thornchg.rkt.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_subject_knowledge")
public class SubjectKnowledge {
    private Integer id;
    @TableField("subject_id")
    private Integer subjectId;
    @TableField("knowledge_id")
    private Integer knowledgeId;
    @TableField("question_type")
    private Integer questionType;
}
