package cn.edu.wj.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.edu.wj.mapper.ActionNodeMapper;
import cn.edu.wj.mapper.RoleNodeMapper;
import cn.edu.wj.model.RoleNode;

@Component
public class RoleNodeService {
	
	@Autowired
	private RoleNodeMapper roleNodemapper;
	
	@Autowired
	private ActionNodeMapper actionNodemapper;

	public void deleteByRoleId(Integer id) {
		roleNodemapper.deleteByPrimaryKey(id);
		
	}

	public void save(RoleNode roleNode) {
		roleNodemapper.insert(roleNode);
	}
	
	public List<Map<String, Object>> getNodeList(Integer roleId) {
		return getNode(0, 4, roleId);
	}

	public List<Map<String, Object>> getNode(int pid,
			int maxLevel, Integer roleId) {
/*		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pid", pid)*/;
		List<Map<String, Object>> formList = actionNodemapper.selectBypid(pid);
		System.out.println("formList:");
		System.out.println(formList);
		List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < formList.size(); i++) {
			Map<String, Object> node = formList.get(i); // 赋给新的map
			node.put("isCheck", false);
			System.out.println("node:");
			System.out.println(node);
			if (roleId != null) {
				int n = roleNodemapper.findByRoleId(roleId,
						Integer.valueOf(node.get("id").toString()));//node.get("id")对象
				if (n!=0) {
					node.put("isCheck", true);
				}
			}
			if (true) {
				node.put("children",getNode(Integer.valueOf(node.get("id").toString()),maxLevel, roleId));
			}
			res.add(node);
		}
		return res;
	}
}
