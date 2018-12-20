package cn.edu.wj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.wj.model.GAdmin;
import cn.edu.wj.model.GPatientInfo;
import cn.edu.wj.service.GAdminService;
import cn.edu.wj.service.GPatientService;
import cn.edu.wj.service.impl.GAdminServiceImpl;
import cn.edu.wj.service.impl.GPatientServiceImpl;
import cn.edu.wj.util.Fn;
import cn.edu.wj.util.UIUtils;
/**
 * 梅总好
 * @author zzzzzzzzq
 *
 */
@Controller
public class ControllerTest {
	@Autowired
	GAdminService reqService;
	@Autowired
	GPatientService gPatientService;
	
	@Autowired
    private GAdminServiceImpl gadminServiceImpl;
	
//	@Autowired
//    private GPatientServiceImpl gpatientServiceImpl;
	
//	@RequestMapping("/main")
//    public String Main(Model m) throws Exception{ 
//        return "/Demo_iframe";
//    }
	
	@RequestMapping("/main")
    public String Main() throws Exception{ 
        return "/main";
    }
	@RequestMapping("/index")//原本是index
    public String index(Model m) throws Exception{ 
		System.out.println("测试页面");
        return "/index";
    }
	
//	@RequestMapping("/registration")
//    public String Registration() throws Exception{ 
//        return "/registration";
//    }
    
//    @RequestMapping("/choice_doctor")
//    public String ChoiceDoctor() throws Exception{ 
//        return "/choice_doctor";
//    }
    
//    @RequestMapping("/registration_fee")
//    public String RegistrationFee() throws Exception{ 
//        return "/registration_fee";
//    }
	
	@RequestMapping("/default")
    public String Default() throws Exception{ 
        return "/default";
    }
	
	@RequestMapping("/gad_info")//原本是index
    public String test(Model m) throws Exception{ 
		List<GAdmin> GAdmin = reqService.findGAdmin();
		System.out.println(GAdmin);
		m.addAttribute("GAdmin",GAdmin);
		System.out.println("123");
        return "/gad_info";
    }
	
//	分页
	@RequestMapping("/gadlist")
    public String list1(HttpServletRequest request, HttpServletResponse response,int page,int limit) throws Exception{ 
		System.out.println("gadlist");
    	System.out.println(page);
    	System.out.println(limit);
    	return Fn.ajaxReturn(response,gadminServiceImpl.getUIGridData1(page,limit,UIUtils.getPageParams(request)));
    }
	
	@RequestMapping(value="/add_gad" ,method = {RequestMethod.POST})
    public String add_gad(Model m ,HttpServletRequest request) throws Exception{ 
//		List<GAdmin> GAdmin = reqService.insertGAdmin();
//		System.out.println(GAdmin);
//		m.addAttribute("GAdmin",GAdmin);
		System.out.println("3457");
			String loginName =request.getParameter("loginName");
			String loginPass =request.getParameter("loginPass");
			String nickname =request.getParameter("nickname");
			String email =request.getParameter("email");
			String addTime_s =request.getParameter("addTime");
			String lastLoginTime_s =request.getParameter("lastLoginTime");
			int addTime =Integer.valueOf(addTime_s);
			int lastLoginTime =Integer.valueOf(lastLoginTime_s);
			boolean isDisabled =false;
//			String GoodsType =request.getParameter("GoodsType");
//			String PicturePath =file.getOriginalFilename();
			System.out.println(loginName+","+loginPass+","+nickname);
			GAdmin gad = new GAdmin();
			gad.setLoginName(loginName);
			gad.setLoginPass(loginPass);
			gad.setNickname(nickname);
			gad.setEmail(email);
			gad.setAddTime(addTime);
			gad.setLastLoginTime(lastLoginTime);
			gad.setIsDisabled(isDisabled);
			int result =reqService.insert(gad);
			
	
		
        return this.test(m);
    }
	
	
	
	@RequestMapping(value="/findByLoginName",method = {RequestMethod.POST})
    public String findByLoginName(Model m,HttpServletRequest request) throws Exception{ 
		String loginName = request.getParameter("loginName");
		System.out.println(loginName);
		List<GAdmin> gad = reqService.findByLoginName(loginName);
		System.out.println(gad);
		m.addAttribute("SimpleUser",gad);
		return "/index";
		
        
    }
}
