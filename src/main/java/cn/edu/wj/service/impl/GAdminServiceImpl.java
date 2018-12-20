package cn.edu.wj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.edu.wj.model.GAdmin;
import cn.edu.wj.service.GAdminService;
import cn.edu.wj.model.GAdmin;
import cn.edu.wj.util.UIUtils;
import cn.edu.wj.mapper.GAdminMapper;

@Service
public class GAdminServiceImpl implements GAdminService{
	@Autowired
	private GAdminMapper GAdminMapper;
	
	@Override
	public List<GAdmin> findGAdmin(){
		
		return GAdminMapper.findGAdmin();
	}
	
	@Override
	public int insert(GAdmin gad) {
		// TODO Auto-generated method stub
		int result =GAdminMapper.insertSQL(gad);
		return 0;
	}
	
	public Map<String, Object> getUIGridData1(int page,int limit,Map<String, String> pageMap) {
		int m=(page-1)*limit;
		int n=limit;
		List<GAdmin> list=GAdminMapper.findGAdmin();
		List<GAdmin> list2=GAdminMapper.selectPage(m,n);
		int count=list.size();
		int count2=list2.size();
		System.out.println(count2+"!!");
		System.out.println(list);
		System.out.println(count);
		return UIUtils.getGridData(count, list2);
	}

	@Override
	public List<GAdmin> checkLogin(GAdmin gad) {
		// TODO Auto-generated method stub
		List<GAdmin> result = GAdminMapper.checkLogin(gad);
		return result;
	}

	@Override
	public List<GAdmin> findByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return GAdminMapper.findByLoginName(loginName);
	}

	@Override
	public boolean ifDisable(String loginName) {
		// TODO Auto-generated method stub
		return GAdminMapper.ifDisable(loginName);
	}

	@Override
	public int findId(String loginName) {
		// TODO Auto-generated method stub
		return GAdminMapper.findId(loginName);
	}

	
	
}
