package cn.edu.wj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wj.model.GMedicine;
import cn.edu.wj.service.GMedicineService;
import cn.edu.wj.mapper.GMedicineMapper;

@Service
public class GMedicineServiceImpl implements GMedicineService{
	@Autowired 
	GMedicineMapper GMedicineMapper;
	
	@Override
	public int addMedicine(GMedicine gMedicine) {
		// TODO Auto-generated method stub
		return GMedicineMapper.addMedicine(gMedicine);
	}

	@Override
	public List<GMedicine> findMedicine() {
		// TODO Auto-generated method stub
		return GMedicineMapper.findMedicine();
	}
	
}
