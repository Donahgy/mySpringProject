package com.pandong.mapper;

import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
	public boolean selectById(long l);
}
