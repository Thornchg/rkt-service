package com.thornchg.rkt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thornchg.rkt.entity.User;
import com.thornchg.rkt.entity.vo.UserVo;
import com.thornchg.rkt.mapper.UserMapper;
import com.thornchg.rkt.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public UserVo getVoByEmail(String email) {
        return baseMapper.findVoByEmail(email);
    }

    @Override
    public User getByEmail(String email) {
        return baseMapper.findByEmail(email);
    }

    @Override
    public UserVo getVoById(String id) {
        return baseMapper.findVoById(id);
    }
}
