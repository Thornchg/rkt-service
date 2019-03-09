package com.thornchg.rkt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.javafx.beans.IDProperty;
import com.thornchg.rkt.config.CustomDateSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.UUID)
    private String id;
    private String email;
    @TableField("nick_name")
    private String nickName;
    private String password;
    private String salt;
    private String avatar;
    @TableField("role_id")
    private Integer roleId;
    private Integer subjectId;       // 已报名的科目
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer status;


}
