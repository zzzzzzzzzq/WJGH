package cn.edu.wj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.wj.model.GAdmin;
import cn.edu.wj.model.GMedicine;
import cn.edu.wj.model.GPatientInfo;
import cn.edu.wj.service.GMedicineService;

@Controller
public class MedicineController {
	@Autowired
	GMedicineService gMedicineService;
	
	@RequestMapping("/storage")//原本是index
    public String medicine(Model m) throws Exception{ 
		List<GMedicine> gMedicine = gMedicineService.findMedicine();
		System.out.println(gMedicine);
		m.addAttribute("GAdmin",gMedicine);
		System.out.println("药库管理/////////////////////");
        return "/storage";
    }
	
	@RequestMapping(value="/addMedicine",method = {RequestMethod.POST})
	public String addMedicine(Model m,HttpServletRequest request) throws Exception{ 
		String name = request.getParameter("loginIden");
		String price = request.getParameter("loginIden");
		String repertory = request.getParameter("loginIden");//库存
		String type = request.getParameter("loginIden");//类别
		String function = request.getParameter("loginIden");//药效
		String remark = request.getParameter("loginIden");//用法
		System.out.println(name+price+repertory+type+function+remark);
		GMedicine gMedicine = new GMedicine();
		int result = gMedicineService.addMedicine(gMedicine);
		System.out.println("返回结果为"+result);
		
		m.addAttribute("",result);
		return "/main";
    }
}
