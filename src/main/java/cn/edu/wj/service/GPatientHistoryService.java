package cn.edu.wj.service;

import java.util.List;

import cn.edu.wj.model.GPatientHistory;


public interface GPatientHistoryService {

	 List<GPatientHistory> findGPatientHistory(String patientIdentityid);
	 
	 List<GPatientHistory> findAllGPatientHistory(String patientIdentityid);
	 
	 int updateGPatientHistory(GPatientHistory gph);
}
