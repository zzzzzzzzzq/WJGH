package cn.edu.wj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.wj.model.GAdmin;
import cn.edu.wj.model.GPatientHistory;
import cn.edu.wj.model.GPatientInfo;
import cn.edu.wj.service.GPatientHistoryService;
import cn.edu.wj.service.GPatientService;
import cn.edu.wj.service.impl.GPatientHistoryServiceImpl;
import cn.edu.wj.util.Fn;
import cn.edu.wj.util.UIUtils;

@Controller
public class JiuzhenController {
	@Autowired
	GPatientService gPatientService;
	@Autowired
	GPatientHistoryService gphService;
	@Autowired
	GPatientHistoryServiceImpl gphServiceImpl;
	
	@RequestMapping("/visit")
    public String Visit() throws Exception{ 
        return "/visit";
    }
	
	@RequestMapping(value="/start_visit",method = {RequestMethod.POST})
    public String StartVisit(HttpServletRequest request, Model m) throws Exception{ 
		int patientcardId = Integer.valueOf(request.getParameter("patientcardId"));
		System.out.println(patientcardId);
		String patientIdentityid = gPatientService.selectPatientIdentityid(patientcardId);
		List<GPatientInfo> GPatientInfo = gPatientService.selectPatientInfo(patientIdentityid);
		System.out.println("返回结果为"+GPatientInfo);
		m.addAttribute("gpi",GPatientInfo);
		
		List<GPatientHistory> GPatientHistory = gphService.findGPatientHistory(patientIdentityid);
		m.addAttribute("gph",GPatientHistory);
		m.addAttribute("pId",patientIdentityid);
		System.out.println("返回结果为"+GPatientHistory);
		
        return "/visit";
    }
	
	@RequestMapping("/gphlist")
    public String list1(HttpServletRequest request, HttpServletResponse response,int page,int limit) throws Exception{ 
		System.out.println("gphlist");
    	System.out.println(page);
    	System.out.println(limit);
		String patientIdentityid = request.getParameter("patientIdentityid");
		System.out.println(patientIdentityid);
    	return Fn.ajaxReturn(response,gphServiceImpl.getUIGridData1(patientIdentityid,page,limit,UIUtils.getPageParams(request)));
    }
	
	@RequestMapping(value="/update_disease",method = {RequestMethod.POST})
    public String UpdateDisease(HttpServletRequest request, Model m) throws Exception{ 
		String diseaseTitle = request.getParameter("diseaseTitle");
		String diseaseContent = request.getParameter("diseaseContent");
		String patientIdentityid = request.getParameter("patientIdentityid");
		GPatientHistory gph = new GPatientHistory();
		gph.setPatientIdentityid(patientIdentityid);
		gph.setDiseaseTitle(diseaseTitle);
		gph.setDiseaseContent(diseaseContent);
		System.out.println("返回结果为"+diseaseTitle+","+diseaseContent+","+patientIdentityid);
		int result = gphService.updateGPatientHistory(gph);
		
		List<GPatientInfo> GPatientInfo = gPatientService.selectPatientInfo(patientIdentityid);
		System.out.println("返回结果为"+GPatientInfo);
		m.addAttribute("gpi",GPatientInfo);
		
		List<GPatientHistory> GPatientHistory = gphService.findGPatientHistory(patientIdentityid);
		m.addAttribute("gph",GPatientHistory);
		System.out.println("返回结果为"+GPatientHistory);
		
		m.addAttribute("pId",patientIdentityid);
		
        return "/visit";
    }
	
	@RequestMapping("/medicine_allocation")
    public String MedicineAllocation(HttpServletRequest request, HttpServletResponse response,int page,int limit) throws Exception{ 
		System.out.println("gphlist");
    	System.out.println(page);
    	System.out.println(limit);
		String patientIdentityid = request.getParameter("patientIdentityid");
		System.out.println(patientIdentityid);
    	return "medicine_allocation";
    }
	
}
