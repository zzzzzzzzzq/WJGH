package cn.edu.wj.service;

import java.util.Collection;


import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.edu.wj.mapper.ActionNodeMapper;
import cn.edu.wj.model.ActionNode;
import cn.edu.wj.util.UIUtils;
import cn.edu.wj.util.zzqUIUtils;


@Component
public class ActionNodeService {
	
	@Autowired
	private ActionNodeMapper mapper;
	
	public List<Map<String, Object>> getLeftNodeList(Integer roleId) {
		List<Map<String, Object>> list=mapper.selectAll(roleId);
		for (Map<String, Object> one : list) {
			List<Map<String, Object>> children=mapper.selectchildren(Integer.parseInt(one.get("id").toString()),roleId);
			one.put("children", children);
		}
		System.out.println(list);
		return list; 
	}
	
	public Map<String, Object> getUIGridData() {
		List<Map<String, Object>> list=mapper.selectNode();
		int count=list.size();
		return zzqUIUtils.getGridData(count, list);
	}

	public List<Map<String, Object>> getUIComboData() {
		return getNodeTree(/*"id,name AS text,pid,level,sort_id"*/0,5);
	}

	public List<Map<String, Object>> getNodeTree( Integer pid, Integer maxLevel) {
		// 查询条件
		/*tring sql = SQLBuilder.getSQLBuilder(ActionNode.class).fields(fields)
				.where("pid=" + pid).order("sort_id", "ASC").selectSql();
		List<Row> list = sqlRunner.select(sql);*/
		List<Map<String, Object>> list = mapper.selectBypid2(pid);
		for (Map<String, Object> one : list) {
			one.put("children",getNodeTree(Integer.parseInt(one.get("id").toString()),maxLevel));
/*			if (Integer.valueOf(one.get("level").toString()) < maxLevel) {
				one.put("children",getNodeTree(Integer.parseInt(one.get("id").toString()),maxLevel));
			}*/
		}
		return list;
	}

	public void save(ActionNode actionNode) {
		actionNode.setLevel(2);
		mapper.insert(actionNode);
		
	}

	public int deletenode(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public void update(ActionNode actionNode) {
		mapper.updateByPrimaryKeySelective(actionNode);
		
	}

	public ActionNode findById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	
}
