package cn.edu.wj.service;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.edu.wj.mapper.RoleMapper;
import cn.edu.wj.model.Role;
import cn.edu.wj.util.UIUtils;
import cn.edu.wj.util.zzqUIUtils;


@Component
public class AdminService {
	
	@Autowired
	private RoleMapper rolemapper;
	
	
	public Map<String, Object> getUIGridData(Map<String, Object> where,Map<String, String> pageMap) {
		Integer m = (Integer.parseInt(pageMap.get("page"))-1)*(Integer.parseInt(pageMap.get("rows")));
		Integer n = Integer.parseInt(pageMap.get("rows"));
		List<Role> list = rolemapper.selectAll();	
		List<Role> list2=rolemapper.selectPage(m,n);
		int count=list.size();
		return zzqUIUtils.getGridData(count, list);
	}


	public int save(Role entity) {
		return rolemapper.insert(entity);
	}


	public int update(Role entity) {
		return rolemapper.updateByPrimaryKey(entity);
	}


	public Role findById(Integer id) {
		return rolemapper.selectByPrimaryKey(id);
	}


	public void delete(Integer id) {
		rolemapper.deleteByPrimaryKey(id);
	}
	

}
