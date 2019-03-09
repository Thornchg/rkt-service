package com.thornchg.rkt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("t_paper")
public class Paper {
    @TableId(type = IdType.UUID)
    private String id;
    private String title;
    private Integer subjectId;
    private Integer questionType; // 试卷题型 1 综合知识 2 案例 ...
    private Integer paperTypeId;          // 试卷类型 1 每日一练 2 模拟 3 历年 4 专项知识点 5 错题重做
    private String questions;       // 题目 xml格式存储
    private Integer total;        // 总分
    private Integer count;        // 题数
    private Integer time;    //考试时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String creatorId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String updaterId;
    private Integer status;        // 状态 1 未发布 2 已发布
}
