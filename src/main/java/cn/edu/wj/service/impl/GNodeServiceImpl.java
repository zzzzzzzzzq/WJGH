package cn.edu.wj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wj.mapper.GNodeMapper;
import cn.edu.wj.service.GNodeService;

@Service
public class GNodeServiceImpl implements GNodeService {
@Autowired
GNodeMapper gNodeMapper;
	
	@Override
	public List<Map<String, Object>> getLeftNodeList(Integer roleId) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = gNodeMapper.selectAll(roleId);
		for(Map<String,Object> one:list){
			List<Map<String,Object>> children = gNodeMapper.selectchildren(Integer.parseInt(one.get("id").toString()),roleId);
			one.put("children", children);
		}
		System.out.println(list);
		return list;
	}
}
