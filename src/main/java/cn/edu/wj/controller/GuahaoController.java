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

import cn.edu.wj.model.GPatientRegistration;
import cn.edu.wj.model.GPayRecord;
import cn.edu.wj.service.GPatientRegistrationService;
import cn.edu.wj.service.GPayRecordService;
/**
 * 刘远荣傻狗
 * @author lowke
 *
 */
@Controller
public class GuahaoController {
	@Autowired
	GPatientRegistrationService gpaService;
	@Autowired
	GPayRecordService gpayService;
	
	
	@RequestMapping("/registration")
    public String Registration() throws Exception{ 
        return "/registration";
    }
	
	@RequestMapping("/choice_doctor")
    public String ChoiceDoctor() throws Exception{ 
        return "/choice_doctor";
    }
	
	@RequestMapping("/registration_fee")
    public String RegistrationFee(HttpServletRequest request, HttpServletResponse response, Model m) throws Exception{ 
		List<String> strs = new ArrayList<String>();
		String doctorName = request.getParameter("doctorName");
		String department = request.getParameter("department");
		System.out.println(doctorName);
		System.out.println(department);
		String price = "10";
		String realPrice = "10";
		strs.add(department);
		strs.add(doctorName);
		strs.add(price);
		strs.add(realPrice);
		m.addAttribute("regFeeInfo",strs);
		
        return "/registration_fee";
    }
	
	@RequestMapping("/real_registration")
    public String RealRegistration(HttpServletRequest request, Model m) throws Exception{ 
		System.out.println("hhhh");
		String patientIdentityid = "330102199003075670";
		String department = request.getParameter("department");
		String doctor = request.getParameter("doctorName");
		boolean isCompleted =false;
		int time = 0;
		int payNo = 1234567891;
		
		String payType = "挂号";
		int payMoney = Integer.valueOf(request.getParameter("payMoney"));
		boolean isPay =false;
		
		System.out.println(patientIdentityid+","+department+","+doctor+","+isCompleted+","+time+","+payNo+","+payMoney);
		GPatientRegistration gpa = new GPatientRegistration();
		gpa.setPatientIdentityid(patientIdentityid);
		gpa.setDepartment(department);
		gpa.setDoctor(doctor);
		gpa.setIsCompleted(isCompleted);
		gpa.setTime(time);
		gpa.setPayNo(payNo);
		int result = gpaService.insert(gpa);
		
		GPayRecord gpay = new GPayRecord();
		gpay.setPayNo(payNo);
		gpay.setPayType(payType);
		gpay.setPayMoney(payMoney);
		gpay.setIsPay(isPay);
		int result2 =gpayService.insert(gpay);
		
		
        return "/registration";
    }
	
}
