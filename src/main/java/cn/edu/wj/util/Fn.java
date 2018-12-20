package cn.edu.wj.util;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

/**
 * 通用函数
 * @author Simon
 *
 */
public class Fn {
	/**
	 * ajax返回json数据
	 * @param response
	 * @param data 要返回的数据
	 */
	public static String ajaxReturn(HttpServletResponse response,Object data){
		render(response,JSON.toJSONString(data),"json");
		return null;
	}
	
	
	/**
	 * ajax返回json数据，参数重载
	 * @param response
	 * @param data 要返回的数据
	 * @param info 返回的信息
	 * @param status 返回的状态
	 * @return
	 */
	public static String ajaxReturn(HttpServletResponse response,Object data,String info,int status){
		
		Map<String, Object> jsonData = new HashMap<String,Object>();
		jsonData.put("data", data);
		jsonData.put("info", info);
		jsonData.put("status", status);
		
		render(response,JSON.toJSONString(jsonData),"json");
		return null;
	}
	
	
	/**
	 * 发送内容。使用UTF-8编码。
	 * 
	 * @param response
	 * @param contentType
	 * @param text
	 */
	public static void render(HttpServletResponse response,String text,String... contentType) {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(text);  
		    out.flush();  
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}

}
