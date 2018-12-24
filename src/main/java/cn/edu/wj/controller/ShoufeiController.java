package cn.edu.wj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.wj.model.GPayRecord;
import cn.edu.wj.service.GPayRecordService;
import cn.edu.wj.service.impl.GPayRecordServiceImpl;
import cn.edu.wj.util.Fn;
import cn.edu.wj.util.UIUtils;


@Controller
public class ShoufeiController {

	@Autowired
	GPayRecordService gprService;
	@Autowired
	GPayRecordServiceImpl gprServiceImpl;
	
	
	@RequestMapping(value="/pay")
    public String Pay() throws Exception{ 
        return "/pay";
    }
	
	@RequestMapping(value="/start_pay",method = {RequestMethod.POST})
    public String StartPay(HttpServletRequest request, Model m) throws Exception{ 
		int payNo = Integer.valueOf(request.getParameter("payNo"));
		m.addAttribute("payNo",payNo);	
        return "/pay";
    }
	
	@RequestMapping(value="/paylist")
    public String Paylist(HttpServletRequest request, HttpServletResponse response,int page,int limit) throws Exception{ 
		try{
			int payNo = Integer.valueOf(request.getParameter("payNo"));
			System.out.println(payNo);	
			return Fn.ajaxReturn(response,gprServiceImpl.getUIGridData1(payNo,page,limit,UIUtils.getPageParams(request)));
		}catch(NumberFormatException ex){ // handle your exception
			System.out.println("11111");
			return null;
		}
    }
	
	
	
}
 