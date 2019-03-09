package com.thornchg.rkt.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thornchg.rkt.config.CustomDateSerializer;
import com.thornchg.rkt.entity.Paper;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PaperVo {
    private String id;
    private String title;
    @TableField("subject_id")
    private Integer subjectId;
    @TableField("subject_name")
    private String subjectName;
    @TableField("question_type")
    private Integer questionType; // 试卷题型 1 综合知识 2 案例 ...
    @TableField("paper_type_id")
    private Integer paperTypeId;          // 试卷类型 1 每日一练 2 模拟 3 历年 4 专项知识点 5 错题重做
    private Object questions;       // 题目 xml格式存储
    private Integer total;        // 总分
    private Integer count;        // 题数
    private Integer time;    //考试时间  时间戳
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;
    @TableField("creator")
    private String creator;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private Date updateTime;
    @TableField("updater")
    private String updater;
    private Integer status;        // 状态 1 未发布 2 已发布
    public Paper toPaper(){
        Paper paper=new Paper();
        paper.setTitle(this.title);
        paper.setSubjectId(this.subjectId);
        paper.setQuestionType(this.questionType);
        paper.setPaperTypeId(this.paperTypeId);
        paper.setTotal(this.total);
        paper.setCount(this.count);
        paper.setTime(this.time);
        return paper;
    }
}
