package cn.edu.wj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wj.mapper.GPatientHistoryMapper;
import cn.edu.wj.model.GPatientHistory;
import cn.edu.wj.service.GPatientHistoryService;
import cn.edu.wj.util.UIUtils;


@Service
public class GPatientHistoryServiceImpl implements GPatientHistoryService {
	@Autowired
	private GPatientHistoryMapper GPatientHistoryMapper;
	
	@Override
	public List<GPatientHistory> findGPatientHistory(String patientIdentityid) {
		// TODO Auto-generated method stub
		return GPatientHistoryMapper.findGPatientHistory(patientIdentityid);
	}
	
	public Map<String, Object> getUIGridData1(String patientIdentityid,int page,int limit,Map<String, String> pageMap) {
		int m=(page-1)*limit;
		int n=limit;
		List<GPatientHistory> list=GPatientHistoryMapper.findAllGPatientHistory(patientIdentityid);
		List<GPatientHistory> list2=GPatientHistoryMapper.selectPage(m,n,patientIdentityid);
		int count=list.size();
		int count2=list2.size();
		System.out.println(count2+"!!");
		System.out.println(list);
		System.out.println(count);
		return UIUtils.getGridData(count, list2);
	}

	@Override
	public int updateGPatientHistory(GPatientHistory gph) {
		// TODO Auto-generated method stub
		return GPatientHistoryMapper.updateGPatientHistory(gph);
	}

	@Override
	public List<GPatientHistory> findAllGPatientHistory(String patientIdentityid) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
}
