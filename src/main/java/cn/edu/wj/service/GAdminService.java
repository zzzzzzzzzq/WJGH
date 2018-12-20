package cn.edu.wj.service;

import java.util.List;

import cn.edu.wj.model.GAdmin;

public interface GAdminService {

	public List<GAdmin> findGAdmin();
	
	int insert(GAdmin gad);
	
	List<GAdmin> checkLogin(GAdmin gad);

	List<GAdmin> findByLoginName(String loginName);

	boolean ifDisable(String loginName);

	 int findId(String loginName);


}
