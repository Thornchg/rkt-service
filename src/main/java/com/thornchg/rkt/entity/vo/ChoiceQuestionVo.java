package com.thornchg.rkt.entity.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thornchg.rkt.config.CustomDateSerializer;
import com.thornchg.rkt.entity.Question;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class ChoiceQuestionVo {
    private String id;
    private Integer index;
    private String topic;
    @TableField("question_type")
    private Integer questionType;
    @TableField("knowledge_id")
    private Integer knowledgeId;
    @TableField("knowledge_name")
    private String knowledgeName;
    @TableField("subject_id")
    private String subjectId;
    @TableField("subject_name")
    private String subjectName;
    private Object selects;
    private String answer;
    private String resolve;
    @TableField("create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = CustomDateSerializer.class)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss") // fastJson 转成json字符串 Date类型格式化 默认为时间戳

    private Date createTime;
    private String creator;
    @TableField("update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = CustomDateSerializer.class)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss") // fastJson 转成json字符串 Date类型格式化 默认为时间戳
    private Date updateTime;
    private String updater;

    public Question toQuestion(){
        Question question=new Question();
        question.setTopic(this.topic);
        question.setKnowledgeId(this.knowledgeId);
        question.setResolve(this.resolve);
        question.setSelects(JSON.toJSONString(selects));
        return question;
    }
}
