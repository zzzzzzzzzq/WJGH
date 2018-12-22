package cn.edu.wj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.wj.model.GAdmin;
import cn.edu.wj.model.GPatientInfo;
import cn.edu.wj.service.GAdminService;
import cn.edu.wj.service.GPatientService;
import cn.edu.wj.service.RoleService;
import cn.edu.wj.service.GNodeService;

@Controller
public class IndexController {
	@Autowired
	GAdminService reqService;
	@Autowired
	GPatientService gPatientService;
	@Autowired
	RoleService roleService;
	@Autowired
	GNodeService gNodeService;
	
	@RequestMapping("/login")
    public String loginPage() throws Exception{ 
        return "/login";
    }
	
	@RequestMapping(value="/loginCheck",method = {RequestMethod.POST})
    public String login(Model m,HttpServletRequest request) throws Exception{ 
		String loginName = request.getParameter("loginName");
		String loginPass = request.getParameter("loginPass");
		System.out.println(loginName);
		System.out.println(loginPass);
		
		GAdmin gad = new GAdmin();
		gad.setLoginName(loginName);
		gad.setLoginPass(loginPass);
		List<GAdmin> result = reqService.checkLogin(gad);
		System.out.println("用户信息返回结果为"+result);
		if(result.isEmpty()){
			m.addAttribute("flag", 0);
			return "/login";
		}
		boolean status = reqService.ifDisable(loginName);
		System.out.println("用户状态为"+status);//false为未禁用，true为用户已禁用
		if(status == true){
		m.addAttribute("flag",3);//flag为3为用户状态异常
		return "/login";
		}
		int userId = reqService.findId(loginName);//获取UserID
		System.out.println("userid =" + userId);
		Integer roleId = roleService.findRoleId(userId);//获取roleId
		System.out.println("roleId="+roleId);
		request.getSession().setAttribute("roleId",roleId);//将Roid存入网页缓存
		
		m.addAttribute("leftMenuList",gNodeService.getLeftNodeList(roleId));
		
		return "/main";
		
    }
	@RequestMapping(value="/patientLogin",method = {RequestMethod.POST})
	public String Patlogin(Model m,HttpServletRequest request) throws Exception{ 
		String patientIden = request.getParameter("loginIden");//身份证号
		System.out.println(patientIden);
		List<GPatientInfo> GPatientInfo = gPatientService.patientLogin(patientIden);
		System.out.println("返回结果为"+GPatientInfo);
		if(GPatientInfo.isEmpty()){
			m.addAttribute("flag",3);//flag为3为用户状态异常
			return "/login";
		}
		int roleId = 6;
		m.addAttribute("leftMenuList",gNodeService.getLeftNodeList(roleId));
		return "/main";
    }
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response,HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:login";
	}
}
