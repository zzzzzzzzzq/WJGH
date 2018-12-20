package cn.edu.wj.util;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class UIUtils {

	/**
     * 获取前端控件传回来的分页参数
     * @return
     */
	public static Map<String,String> getPageParams(HttpServletRequest req) {
		
		Map<String,String> map= new HashMap<String,String>();
		String[] params = {"page","rows","sort","order"};
		for(String p:params){
			String v = req.getParameter(p);
			if(v!=null){
				map.put(p, v);
			}
		}
		return map;
	}
	
	/**
	 * 组装前端datagrid组件需要的数据
	 * @param totalCount 记录总数
	 * @param data 结果集
	 * @return
	 */
	public static Map<String, Object> getGridData(Integer totalCount,List<?> data){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("count", totalCount);
		res.put("data", data);
		res.put("code", 0);
		res.put("msg", "");
		System.out.println(res);
		return res;
	}
	
	public static String pageFmt(Map<String, String> pageMap){
		Integer m = (Integer.parseInt(pageMap.get("page"))-1)*(Integer.parseInt(pageMap.get("rows")));
		Integer n = Integer.parseInt(pageMap.get("rows"));
		return "limit "+m+","+n;	
	}
	
	public static String orderFmt(Map<String,Object> where){
		String name = where.get("sortName").toString();
		String order = where.get("sortOrder").toString();
		if(name!=""){
			return " ORDER BY "+name+" "+order+" ";
		}else{
			return " ORDER BY readed ASC,id DESC ";
		}
	}
	
	public static Map<String, Object> getMap_Err(Integer status,List<?> data){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", status);
		res.put("data", data);
		return res;
	}
	public static Map<String, Object> getMapWorkorder(String status,List<?> data,String mes){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", status);
		res.put("data", data);
		res.put("message", mes);
		return res;
	}
	public static Map<String, Object> getDataID(String status,Integer data,String mes){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", status);
		res.put("data", data);
		res.put("message", mes);
		return res;
	}

	public static Map<String, Object> getPrijectNumberResult(boolean status,String data){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", status);
		res.put("data", data);
		return res;
	}
	public static Map<String, Object> getcheckRepeat(String status,String mes){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", status);
		res.put("message", mes);
		return res;
	}
}
