package cn.edu.wj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wj.mapper.GPatientInfoMapper;
import cn.edu.wj.model.GPatientInfo;
import cn.edu.wj.service.GPatientService;

@Service
public class GPatientServiceImpl implements GPatientService {
	@Autowired
	private GPatientInfoMapper GPatientInfoMapper;
	
	@Override
	public List<GPatientInfo> patientLogin(String patientIden) {
		// TODO Auto-generated method stub
		
		return GPatientInfoMapper.findPatient(patientIden);
	}

}
