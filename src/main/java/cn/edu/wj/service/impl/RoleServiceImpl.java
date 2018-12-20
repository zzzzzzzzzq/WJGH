package cn.edu.wj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wj.mapper.GAdminRoleMapper;
import cn.edu.wj.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
@Autowired
GAdminRoleMapper GAdminRoleMapper;

	@Override
	public Integer findRoleId(int userId) {
		// TODO Auto-generated method stub
		return GAdminRoleMapper.findRoleId(userId);
	}

	

}
