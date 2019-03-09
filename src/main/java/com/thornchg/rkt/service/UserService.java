package com.thornchg.rkt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thornchg.rkt.entity.User;
import com.thornchg.rkt.entity.vo.UserVo;

public interface UserService extends IService<User> {
    UserVo getVoByEmail(String email);
    User getByEmail(String email);
    UserVo getVoById(String id);
}
