package com.thornchg.rkt.entity;

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
@TableName("t_record")
public class Record {
    @TableId(type = IdType.UUID)
    private String id;
    private String userId;
    private String paperId;
    private String paper;           // 结果试卷
    private Integer score;
    private String answer;          // 用户做的答案
    private Long limitTimeStamp;    // 限定时间 时间戳
    @TableField("used_time")
    private Long usedTime;     // 已完成时间 时间戳
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer status;          // 状态 0 未交卷 1 已交卷未审核 2完成
    @TableField("submit_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date submitTime;
}
