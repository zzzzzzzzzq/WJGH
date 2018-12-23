package cn.edu.wj.controller;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.wj.model.ActionNode;
import cn.edu.wj.model.Role;
import cn.edu.wj.model.RoleNode;
import cn.edu.wj.service.ActionNodeService;
import cn.edu.wj.service.AdminService;
import cn.edu.wj.service.RoleNodeService;
import cn.edu.wj.util.Fn;
import cn.edu.wj.util.UIUtils;


/**
 * 节点模块
 * @author zzzzzzzzq
 *
 */
@Controller
@RequestMapping(value = { "admin" })
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	RoleNodeService roleNodeService;
	
	@Autowired
	ActionNodeService actionNodeService;
	
	@RequestMapping(value = { "action_node" })
	public String actionNode(HttpServletRequest request,
			HttpServletResponse response) {
		if (request.getMethod().equals("POST")) {	
			if ("combo".equals(request.getParameter("ui"))) {
				List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
				Map<String, Object> node = new HashMap<String, Object>();
				node.put("id", 0);
				node.put("text", "--顶级节点--");
				res.add(node);
				res.addAll(actionNodeService.getUIComboData());
				System.out.println(res);
				return Fn.ajaxReturn(response, res);
			} else {
				Map<String, Object> list= actionNodeService.getUIGridData();
				System.out.println(list);
				return Fn.ajaxReturn(response,list);
			}
		} else {
			return "/action_node";
		}
	}
	
	@RequestMapping(value = { "action_node_add" })
	public String actionNodeAdd(HttpServletRequest request,
			HttpServletResponse response, ActionNode actionNode) {
		if (request.getMethod().equals("POST")) {
			actionNodeService.save(actionNode);
			return Fn.ajaxReturn(response, null, "添加成功", 1);
		} else {
			return "action_node_add";
		}
	}


	@RequestMapping(value = { "action_node_delete" }, method = RequestMethod.POST)
	public String actionNodeDelete(HttpServletRequest request,
			HttpServletResponse response, Integer id) {
		int flag = actionNodeService.deletenode(id);
		if (flag >= 1)
			return Fn.ajaxReturn(response, null, "删除成功", 1);
		else {
			return Fn.ajaxReturn(response, null, "删除失败", 0);
		}
	}


	@RequestMapping(value = { "action_node_edit" })
	public String actionNodeEdit(Model model, HttpServletRequest request,
			HttpServletResponse response, ActionNode actionNode) {
		if (request.getMethod().equals("POST")) {
			actionNodeService.update(actionNode);
			return Fn.ajaxReturn(response, null, "修改成功", 1);
		} else {
			model.addAttribute("actionNode",
					actionNodeService.findById(actionNode.getId()));
			return "action_node_edit";
		}
	}

	
	@RequestMapping(value = { "role" })
	public String list(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		if (request.getMethod().equals("POST")) {
			Map<String, Object> where = new HashMap<String, Object>();
			return Fn.ajaxReturn(
					response,
					adminService.getUIGridData(where,
							UIUtils.getPageParams(request)));
		} else {
			return "admin/role";
		}
	}
	
	@RequestMapping(value = { "role_add" })
	public String roleAdd(Model model, HttpServletRequest request,
			HttpServletResponse response, Role entity) {
		if (request.getMethod().equals("POST")) {
			int flag = adminService.save(entity);
			if (flag == 1) {
				return Fn.ajaxReturn(response, null, "添加成功", 1);
			} else {
				return Fn.ajaxReturn(response, null, "发生错误，请重试！", 0);
			}
		} else {
			return "admin/role_add";
		}
	}
	
	@RequestMapping(value = { "role_edit" })
	public String roleEdit(Model model, HttpServletRequest request,
			HttpServletResponse response, Role entity) {
		if (request.getMethod().equals("POST")) {
			System.out.println(entity.getId());
			int flag = adminService.update(entity);
			if (flag == 1) {
				return Fn.ajaxReturn(response, null, "修改成功", 1);
			} else {
				return Fn.ajaxReturn(response, null, "发生错误，请重试！", 0);
			}
		} else {
			model.addAttribute("role", adminService.findById(entity.getId()));
			return "admin/role_edit";
		}
	}

	@RequestMapping(value = { "role_delete" })
	public String roleDelete(Model model, HttpServletRequest request,
			HttpServletResponse response, Integer id) {
		adminService.delete(id);
		return Fn.ajaxReturn(response, null, "删除成功", 1);
	}
	
	@RequestMapping(value = { "role_access" })
	public String roleAccess(Model model, HttpServletRequest request,
			HttpServletResponse response, Integer id) throws Exception {
		if (request.getMethod().equals("POST")) {
			String[] nodeIds = request.getParameterValues("nodeId");//获得如checkbox类（名字相同，但值有多个）的数据
			roleNodeService.deleteByRoleId(id);
			if (nodeIds != null) {
				for (String nodeId : nodeIds) {
					RoleNode roleNode = new RoleNode();
					roleNode.setRoleId(id);
					roleNode.setNodeId(Integer.valueOf(nodeId));
					roleNodeService.save(roleNode);
				}
			}
			return Fn.ajaxReturn(response, null, "授权成功~", 1);
		} else {
			List<Map<String, Object>> node = roleNodeService.getNodeList(id);
			model.addAttribute("node", node);
			System.out.println("用户权限!:");
			System.out.println(node);
			return "admin/role_access";
		}
	}

}
