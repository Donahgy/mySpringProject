package com.pandong.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * 自定义审批组持久层接口
 * 
 * @author zhangyi
 * @date 2019-02-22
 */

public interface CustomAppGroupMapper
{

    int selectCountWithUserType(Map<String, Object> params, List<String> list, List<String> ids);

    List<Map<String, Object>> selectListWithUserType(Map<String, Object> params, List<String> list);

	List<String> selectProcessUserIdByName(Map<String, Object> params);
}
