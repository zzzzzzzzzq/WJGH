package cn.edu.wj.service;

import java.util.List;

import cn.edu.wj.model.GPatientInfo;

public interface GPatientService {

	 List<GPatientInfo> patientLogin(String patientIden);

	GPatientInfo findPinfo(int opayno);

}
