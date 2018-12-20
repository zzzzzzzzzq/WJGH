package cn.edu.wj.service.impl;

import cn.edu.wj.service.GPatientRegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wj.mapper.GPatientRegistrationMapper;
import cn.edu.wj.model.GPatientRegistration;


@Service
public class GPatientRegistrationServiceImpl implements GPatientRegistrationService {
	@Autowired
	private GPatientRegistrationMapper gpaMapper;
	
	@Override
	public int insert(GPatientRegistration gpa){
		// TODO Auto-generated method stub
				int result =gpaMapper.insertSQL(gpa);
				return 0;
	}
	
	
}
