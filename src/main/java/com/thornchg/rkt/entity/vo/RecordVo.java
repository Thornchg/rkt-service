package com.thornchg.rkt.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class RecordVo {
    private String id;
    private String userId;
    private String paperId;
    private Object paper;           // 结果试卷
    private Integer score;
    private String answer;          // 用户做的答案
    private Long limitTimeStamp;    // 限定时间 时间戳
    @TableField("used_time")
    private Long usedTime;     // 已完成时间 时间戳
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer status;          // 状态 0 未交卷 1 已交卷
}
