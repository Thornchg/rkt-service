package com.thornchg.rkt.entity.vo;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class UserVo {
    private String id;
    private String email;
    private String nickName;
    private String avatar;
    private Integer roleId;
    private Integer subjectId;       // 已报名的科目
    private String phone;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String roleName;
    private String roleCode;
    private String subjectName;
}
