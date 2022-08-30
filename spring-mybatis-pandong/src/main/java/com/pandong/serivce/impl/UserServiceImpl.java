package com.pandong.serivce.impl;

import com.pandong.entity.User;
import com.pandong.mapper.UserMapper;
import com.pandong.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public User selectById(Long id) {
		return userMapper.selectById(id);
	}
}
