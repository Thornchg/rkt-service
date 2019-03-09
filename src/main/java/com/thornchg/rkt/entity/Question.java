package com.thornchg.rkt.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thornchg.rkt.config.CustomDateSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("t_question")
public class Question {
    @TableId(type = IdType.UUID)
    private String id;
    private Integer questionType;    //题目类型 1 综合知识 2 案例 3 论文
    private Integer knowledgeId;     //题目类型为3 则为科目的id
    @TableField("subject_id")
    private Integer subjectId;
    private String topic;
    private String selects;
    private String answer;             //正确答案
    private String resolve;
    @TableField("create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss") // fastJson 转成json字符串 Date类型格式化 默认为时间戳
    private Date createTime;
    private String creatorId;
    @TableField("update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String updaterId;

    private Integer isEnglish;
}
