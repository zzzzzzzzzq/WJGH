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
import cn.edu.wj.model.GOrdinaryCherk;
import cn.edu.wj.model.GPatientHistory;
import cn.edu.wj.model.GPatientInfo;
import cn.edu.wj.service.GOrdinaryCherkService;
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
	GOrdinaryCherkService gocService;
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
	
	
	
	@RequestMapping("/ordinary_cherk")
    public String OrdinaryCherk(HttpServletRequest request, Model m) throws Exception{ 
    	String patientIdentityid = request.getParameter("patientIdentityid");
    	System.out.println(patientIdentityid);
    	int patientId = Integer.valueOf(gPatientService.selectPatientId(patientIdentityid));
    	System.out.println(patientId);
    	m.addAttribute("patientId",patientId);
    	return "ordinary_cherk";
    }
	
	@RequestMapping("/real_ordinary_cherk")
    public String RealOrdinaryCherk(HttpServletRequest request, Model m) throws Exception{ 
		System.out.println("real_ordinary_cherk");
		String id = request.getParameter("patientId");
		int patientId = Integer.valueOf(id);
		System.out.println("你好：我是："+patientId);
		String checks = "1";
		String money = "0";
		String cherk1 = request.getParameter("cherk1");
		if(cherk1!=null)
			checks = checks +","+ cherk1;
			money = money +","+ "50";
		String cherk2 = request.getParameter("cherk2");
		if(cherk2!=null)
			checks = checks +","+ cherk2;
			money = money +","+ "20";
		String cherk3 = request.getParameter("cherk3");
		if(cherk3!=null)
			checks = checks +","+ cherk3;
			money = money +","+ "30";
		String cherk4 = request.getParameter("cherk4");
		if(cherk4!=null)
			checks = checks +","+ cherk4;
			money = money +","+ "60";
		System.out.println(cherk1+","+cherk2+","+cherk3+","+cherk4);
		System.out.println("checks为："+checks);
		String[] checkItems = checks.split(",");
		String[] checkMoneys = money.split(",");
		for (int i = 1; i < checkItems.length; i++) {
            System.out.println(checkItems[i]);
            String checkItem = checkItems[i];
            int checkMoney = Integer.valueOf(checkMoneys[i]);
            GOrdinaryCherk goc = new GOrdinaryCherk();
            goc.setPatientId(patientId);
            goc.setDoctor("外科医生1");
            goc.setCheckItem(checkItem);
            goc.setPayNo(241141612);
            goc.setCheckMoney(checkMoney);
            System.out.println(patientId+",__"+checkItem+",__"+checkMoney);
            int result = gocService.insert(goc);
            
        }
		int a= 1;
    	m.addAttribute("a",a);
    	return "ordinary_cherk";
    }
	
	@RequestMapping("/dispensing")
    public String Dispensing() throws Exception{ 
        return "/dispensing";
    }
	
	@RequestMapping("/finish_visit")
    public String FinishVisit() throws Exception{ 
		String patientIdentityid = "330102199003075670";
		int result = gphService.updateStatus(patientIdentityid);
        return this.Visit();
    }
	
	
}
