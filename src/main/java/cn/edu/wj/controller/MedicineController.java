package cn.edu.wj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.wj.model.GAdmin;
import cn.edu.wj.model.GMedicine;
import cn.edu.wj.model.GMedicineAllocation;
import cn.edu.wj.model.GPatientInfo;
import cn.edu.wj.service.GMedicineService;
import cn.edu.wj.service.impl.GMedicineServiceImpl;
import cn.edu.wj.util.Fn;
import cn.edu.wj.util.UIUtils;

@Controller
public class MedicineController {
	@Autowired
	GMedicineService gMedicineService;
	@Autowired
	GMedicineServiceImpl gMedicineServiceImpl;
	
	@RequestMapping("/medicine")//原本是index
    public String medicine(Model m) throws Exception{ 
//		List<GAdmin> GAdmin = reqService.findGAdmin();
//		System.out.println(GAdmin);
//		m.addAttribute("GAdmin",GAdmin);
//		System.out.println("123");
        return "/medicine";
    }
	
	@RequestMapping("/storage")
    public String medicine(HttpServletRequest request, HttpServletResponse response,int page,int limit) throws Exception{ 
//		List<GMedicine> gMedicine = gMedicineService.findMedicine();
//		System.out.println(gMedicine);
//		m.addAttribute("GAdmin",gMedicine);
		System.out.println("storage");
    	System.out.println(page);
    	System.out.println(limit);
		System.out.println("药库管理///////////////////////");
		return Fn.ajaxReturn(response,gMedicineServiceImpl.getUIGridDataMedicine(page,limit,UIUtils.getPageParams(request)));
		
    }
	
	@RequestMapping(value="/addMedicine",method = {RequestMethod.POST})
	public String addMedicine(Model m,HttpServletRequest request) throws Exception{ 
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int repertory = Integer.parseInt(request.getParameter("repertory"));//库存
		String type = request.getParameter("type");//类别
		String function = request.getParameter("function");//药效
		String remark = request.getParameter("remark");//用法
		System.out.println(name+price+repertory+type+function+remark);
		GMedicine gMedicine = new GMedicine();
		gMedicine.setName(name);
		gMedicine.setPrice(price);
		gMedicine.setRepertory(repertory);
		gMedicine.setType(type);
		gMedicine.setFunction(function);
		gMedicine.setRemark(remark);
		int result = gMedicineService.addMedicine(gMedicine);
		System.out.println("返回结果为"+result);
		
		m.addAttribute("",result);
		return "/succeed";
    }
	@RequestMapping("/form")
    public String form(Model m) throws Exception{ 
        return "form";
    }
	@RequestMapping(value="/delMedicine")
	@ResponseBody
	public String delMedicine(HttpServletRequest request) throws Exception{ 
		int mid = Integer.parseInt(request.getParameter("id"));
//		System.out.println("返回结果为"+result);
		System.out.println("id======"+mid);
		int result = gMedicineService.delMedicine(mid);
		System.out.println(result);
		return "1";
    }
	/////////////////////////////////////////////////////以下为药品销售的方法
	@RequestMapping("/saleMedicine")//原本是index
    public String saleMedicine(Model m) throws Exception{ 
//		List<GAdmin> GAdmin = reqService.findGAdmin();
//		System.out.println(GAdmin);
//		m.addAttribute("GAdmin",GAdmin);
//		System.out.println("123");
        return "/saleMedicine";
    }
	
	@RequestMapping("/unfinishMedicine")
    public String saleMedicine(HttpServletRequest request, HttpServletResponse response,int page,int limit) throws Exception{ 
//		List<GMedicine> gMedicine = gMedicineService.findMedicine();
//		System.out.println(gMedicine);
//		m.addAttribute("GAdmin",gMedicine);
		System.out.println("saleMedicine");
    	System.out.println(page);
    	System.out.println(limit);
		System.out.println("配药管理///////////////////////");//有关药品的service都用gMedicineService
		return Fn.ajaxReturn(response,gMedicineServiceImpl.getUIGridDataSaleMedicine(page,limit,UIUtils.getPageParams(request)));
		
    }
	
	@RequestMapping("/selectPayno")//原本是index
    public String selectPayno(HttpServletRequest request, HttpServletResponse response,int page,int limit) throws Exception{ 
//		List<GAdmin> GAdmin = reqService.findGAdmin();
//		System.out.println(GAdmin);
//		m.addAttribute("GAdmin",GAdmin);
		System.out.println("SELECT!!!!!");
		int payno = Integer.parseInt(request.getParameter("key[payno]"));
		System.out.println("收费单号"+payno+"!!!!!!!!!!!!!!!");
		 HttpSession session = request.getSession();
         //把用户数据保存在session域对象中
         session.setAttribute("payno", payno);
        return Fn.ajaxReturn(response,gMedicineServiceImpl.getUIGridDataSelectMedicine(page,limit,UIUtils.getPageParams(request),payno));
    }
	
	@RequestMapping("/addmdoctorform")
    public String addmdoctorform(HttpServletRequest request,Model m) throws Exception{ 
		 HttpSession session = request.getSession();
		 int payno = (int) session.getAttribute("payno");
		 System.out.println(payno);
        return "addmdoctorform";
    }
	
	@RequestMapping("/finishMedicine")//配药完成
    public String finishMedicine(HttpServletRequest request, HttpServletResponse response) throws Exception{ 
		
		System.out.println("finishMedicine!!!!!");
		int payno = Integer.parseInt(request.getParameter("payno"));
		String medicineDoctor = request.getParameter("name");
		boolean isCompleted = true;
		int date =  (int) System.currentTimeMillis();
//		System.out.println(medicineDoctor);
		GMedicineAllocation record = new  GMedicineAllocation();
		record.setPayNo(payno);
		record.setMedicineDoctor(medicineDoctor);
		record.setCheckDate(date);
		record.setIsCompleted(isCompleted);
		int result = gMedicineService.finishMedicine(record);
		System.out.println(result+"11111");
		System.out.println("收费单号"+payno+"!!!!!!!!!!!!!!!");
        return "/succeed";
    }
}
