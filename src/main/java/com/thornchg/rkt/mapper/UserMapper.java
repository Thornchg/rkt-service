package com.thornchg.rkt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thornchg.rkt.entity.User;
import com.thornchg.rkt.entity.vo.UserVo;

public interface UserMapper extends BaseMapper<User> {
    UserVo findVoByEmail(String email);
    User findByEmail(String email);
    UserVo findVoById(String id);
}
