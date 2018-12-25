package cn.edu.wj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.wj.model.GAdmin;
import cn.edu.wj.model.GMedicine;
import cn.edu.wj.model.GMedicineAllocation;
import cn.edu.wj.model.GOrdinaryCherk;
import cn.edu.wj.model.GPatientHistory;
import cn.edu.wj.model.GPatientInfo;
import cn.edu.wj.model.GPayRecord;
import cn.edu.wj.service.GMedicineService;
import cn.edu.wj.service.GOrdinaryCherkService;
import cn.edu.wj.service.GPatientHistoryService;
import cn.edu.wj.service.GPatientService;
import cn.edu.wj.service.GPayRecordService;
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
	GPayRecordService gpayService;
	@Autowired
	GPatientHistoryServiceImpl gphServiceImpl;
	@Autowired
	GMedicineService gMedicineService;
	
	@RequestMapping("/visit")
    public String Visit() throws Exception{ 
        return "/visit";
    }
	
	@RequestMapping(value="/start_visit")
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
		int payNo = 888231313;
		String payType = "检查";
		boolean isPay =false;
		System.out.println("real_ordinary_cherk");
		String id = request.getParameter("patientId");
		int patientId = Integer.valueOf(id);
		System.out.println("你好：我是："+patientId);
		String checks = "1";
		String money = "0";
		String cherk1 = request.getParameter("cherk1");
		if(cherk1!=null)
			checks = checks +","+ cherk1;
			money = money +","+ "40";	//50为原价
		String cherk2 = request.getParameter("cherk2");
		if(cherk2!=null)
			checks = checks +","+ cherk2;
			money = money +","+ "16";	//20为原价
		String cherk3 = request.getParameter("cherk3");
		if(cherk3!=null)
			checks = checks +","+ cherk3;
			money = money +","+ "24";	//30为原价
		String cherk4 = request.getParameter("cherk4");
		if(cherk4!=null)
			checks = checks +","+ cherk4;
			money = money +","+ "48";	//60为原价
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
            goc.setCheckDoctor("外科医生1");
            goc.setCheckItem(checkItem);
            goc.setPayNo(payNo);
            goc.setCheckMoney(checkMoney);
            System.out.println(patientId+",__"+checkItem+",__"+checkMoney);
            int result = gocService.insert(goc);
            
            GPayRecord gpay = new GPayRecord();
    		gpay.setPayNo(payNo);
    		gpay.setPayType(payType);
    		gpay.setPayMoney(checkMoney);
    		gpay.setIsPay(isPay);
    		int result2 = gpayService.insert(gpay);
            
        }
		
		
		
		int a= 1;
    	m.addAttribute("a",a);
    	return "ordinary_cherk";
    }
	
	@RequestMapping("/dispensing")//原本是index
    public String medicine(Model m) throws Exception{ 
//		List<GAdmin> GAdmin = reqService.findGAdmin();
//		System.out.println(GAdmin);
//		m.addAttribute("GAdmin",GAdmin);
//		System.out.println("123");
        return "/dispensing";
    }
	
	
	@RequestMapping("/sub")
	@ResponseBody
    public String sub(@RequestBody JSONArray arr,HttpServletResponse response,Model m) throws Exception{ 
		System.out.println("sdagfsadg3");
        for(int i=0;i<arr.size();i++){
        	Integer id=JSONObject.parseObject(JSONObject.toJSONString(arr.get(i))).getInteger("id");
        	String name=JSONObject.parseObject(JSONObject.toJSONString(arr.get(i))).getString("name");
            Integer num=JSONObject.parseObject(JSONObject.toJSONString(arr.get(i))).getInteger("num");
            String price=JSONObject.parseObject(JSONObject.toJSONString(arr.get(i))).getString("price");
            System.out.println(id+" "+name+" "+num+" "+price);
            double medicineMoney = Double.valueOf(price);
            System.out.println(medicineMoney);
            int patientId = 1;
            String doctor = "外科医生1";
            boolean isCompleted =false;
            int payNo = 99993123;
            GMedicineAllocation gma = new GMedicineAllocation();
            gma.setPatientId(patientId);
            gma.setDoctor(doctor);
            gma.setMedicineId(id);
            gma.setMedicineNum(num);
            gma.setIsCompleted(isCompleted);
            gma.setPayNo(payNo);
            gma.setMedicineMoney(medicineMoney);
            int result = gMedicineService.insert(gma);
            
            int payMoney = (int)medicineMoney;
            String payType = "配药";
    		boolean isPay =false;
            GPayRecord gpay = new GPayRecord();
    		gpay.setPayNo(payNo);
    		gpay.setPayType(payType);
    		gpay.setPayMoney(payMoney);
    		gpay.setIsPay(isPay);
            int result2 = gpayService.insert(gpay);
        }
        return null;
    }
	
	@RequestMapping("/finish_visit")
    public String FinishVisit() throws Exception{ 
		String patientIdentityid = "330102199003075670";
		int result = gphService.updateStatus(patientIdentityid);
        return this.Visit();
    }
	
	
}
