package com.pandong.serivce.impl;

import com.pandong.mapper.CustomAppGroupMapper;
import com.pandong.serivce.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TestServiceImpl implements TestService
{

	@Autowired
	CustomAppGroupMapper customAppGroupMapper;

	@Override
	public void Test()
	{
		List<String> userTypes = new ArrayList<>();
		userTypes.add("2");
		userTypes.add("3");
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("templateName","测试");
		List<String> ids = new ArrayList<>();
		ids.add("1");
		Map<String,Object> params = new HashMap<>();
		params.put("templateContent","潘东");

		List<String> processUserIds = customAppGroupMapper.selectProcessUserIdByName(params);
		if (processUserIds.size() == 0)
		{
			return;
		}
		System.out.println(customAppGroupMapper.selectCountWithUserType(paramMap,userTypes,processUserIds));
	}
}
