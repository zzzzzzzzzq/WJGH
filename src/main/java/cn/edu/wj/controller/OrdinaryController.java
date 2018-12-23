package cn.edu.wj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.wj.model.GMedicineAllocation;
import cn.edu.wj.model.GOrdinaryCherk;
import cn.edu.wj.service.GOrdinaryService;
import cn.edu.wj.service.impl.GOrdinaryServiceImpl;
import cn.edu.wj.util.Fn;
import cn.edu.wj.util.UIUtils;

@Controller
public class OrdinaryController {
	@Autowired
	GOrdinaryServiceImpl gOrdinaryServiceImpl;
	@Autowired
	GOrdinaryService gOrdinaryService;
	
	@RequestMapping("/ordinary")//原本是index
    public String medicine(Model m) throws Exception{ 
		
        return "/ordinary";
    }
	@RequestMapping("/AllOrdinary")
    public String medicine(HttpServletRequest request, HttpServletResponse response,int page,int limit) throws Exception{ 
//		List<GMedicine> gMedicine = gMedicineService.findMedicine();
//		System.out.println(gMedicine);
//		m.addAttribute("GAdmin",gMedicine);
		System.out.println("AllOrdinary");
    	System.out.println(page);
    	System.out.println(limit);
		System.out.println("检查管理///////////////////////");
		return Fn.ajaxReturn(response,gOrdinaryServiceImpl.getUIGridDataAllOrdinary(page,limit,UIUtils.getPageParams(request)));
		
    }
	@RequestMapping("/selectOpayno")
    public String selectOpayno(HttpServletRequest request, HttpServletResponse response,int page,int limit) throws Exception{ 
//		List<GAdmin> GAdmin = reqService.findGAdmin();
//		System.out.println(GAdmin);
//		m.addAttribute("GAdmin",GAdmin);
		System.out.println("selectOpayno!!!!!");
		int Opayno = Integer.parseInt(request.getParameter("key[opayno]"));
		System.out.println("检查单号"+Opayno+"!!!!!!!!!!!!!!!");
		HttpSession session = request.getSession();
        //把用户数据保存在session域对象中
        session.setAttribute("opayno", Opayno);
        return Fn.ajaxReturn(response,gOrdinaryServiceImpl.getUIGridDatafindOrdinary(page,limit,UIUtils.getPageParams(request),Opayno));
    }
	
	@RequestMapping("/addOdoctorform")
    public String addmdoctorform(HttpServletRequest request,Model m) throws Exception{ 
		 HttpSession session = request.getSession();
		 int opayno = (int) session.getAttribute("opayno");
		 System.out.println(opayno);
        return "addOdoctorform";
    }
	
	@RequestMapping("/finishOrdinary")//j检查完成
    public String finishMedicine(HttpServletRequest request, HttpServletResponse response) throws Exception{ 
		
		System.out.println("finishOrdinary!!!!!");
		int opayno = Integer.parseInt(request.getParameter("opayno"));
		String checkDoctor = request.getParameter("oname");
		String checkResult = request.getParameter("oresult");
		boolean isCompleted = true;
		int date =  (int) System.currentTimeMillis();
//		System.out.println(medicineDoctor);
		GOrdinaryCherk record = new  GOrdinaryCherk();
		record.setPayNo(opayno);
		record.setCheckDoctor(checkDoctor);
		record.setCheckResult(checkResult);
		record.setCheckDate(date);
		record.setIsCompleted(isCompleted);
		int result = gOrdinaryService.finishOrdinary(record);
		System.out.println("检查结果"+result+"11111");
		System.out.println("收费单号"+opayno+"!!!!!!!!!!!!!!!");
        return "/succeed";
    }
}
