package cn.edu.wj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.wj.model.GPatientHistory;
import cn.edu.wj.model.GPayRecord;
import cn.edu.wj.service.GPatientHistoryService;
import cn.edu.wj.service.GPayRecordService;
import cn.edu.wj.service.impl.GPayRecordServiceImpl;
import cn.edu.wj.util.Fn;
import cn.edu.wj.util.UIUtils;

@RestController
public class ShoufeiajaxController {
	@Autowired
	GPayRecordService gprService;
	@Autowired
	GPayRecordServiceImpl gprServiceImpl;
	@Autowired
	GPatientHistoryService gphService;
	
	@RequestMapping(value="/updata")
    public String Updata(HttpServletRequest request, Model m) throws Exception{ 
		String type = request.getParameter("type");
		String id1 = request.getParameter("id");
		int id = Integer.valueOf(id1);
		String value = request.getParameter("value");
		System.out.println(type+" "+id+" "+value);
		GPayRecord gpr = new GPayRecord();
		gpr.setId(id);
		if(type.equals("doctor")){
			gpr.setDoctor(value);
		}
		if(type.equals("pay_way")){
			gpr.setPayWay(value);
		}
//		if(type.equals("pay_time")){
//			int value2 = Integer.valueOf(value);
//			gpr.setPayTime(value2);;
//		}
		
		System.out.println(gpr.getDoctor());
		int result = gprService.updateGPayRecordId(gpr,type);	
		
		
        return null;
    }
	
	@RequestMapping(value="/finish")
    public String Finish(HttpServletRequest request, Model m,HttpServletResponse response,int page,int limit) throws Exception{ 
		String id1 = request.getParameter("id");
		int id = Integer.valueOf(id1);
		String payNo1 = request.getParameter("pay_no");
		int payNo = Integer.valueOf(payNo1);
		System.out.println(id);
		System.out.println(payNo);
		int result = gprService.updateGPayRecord(id);	
		m.addAttribute("payNo",payNo);
		
		String patientIdentityid = "330102199003075670";
		String doctor = "外科医生1";
		boolean isCompleted = false;
		int date = 0;
		GPatientHistory gph = new GPatientHistory();
		gph.setPatientIdentityid(patientIdentityid);
		gph.setDoctor(doctor);
		gph.setIsCompleted(isCompleted);
		gph.setDate(date);
		int result2 =gphService.insert(gph);
		
		
		return Fn.ajaxReturn(response, gprServiceImpl.getUIGridData1(payNo,page,limit,UIUtils.getPageParams(request)));
    }
	
}
