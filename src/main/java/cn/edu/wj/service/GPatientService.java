package cn.edu.wj.service;

import java.util.List;

import cn.edu.wj.model.GPatientInfo;

public interface GPatientService {

	 List<GPatientInfo> patientLogin(String patientIden);
	 
	 List<GPatientInfo> selectPatientInfo(String patientIden);
	 
	 String selectPatientIdentityid(int patientcardId);

	GPatientInfo findPinfo(int opayno);

	 
	 int selectPatientId(String patientIdentityid);


}
