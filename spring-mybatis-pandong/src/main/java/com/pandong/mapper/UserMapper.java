package com.pandong.mapper;

import com.pandong.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
	User selectById(long l);
}
