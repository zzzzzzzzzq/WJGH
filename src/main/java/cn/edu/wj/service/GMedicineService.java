package cn.edu.wj.service;

import java.util.List;

import cn.edu.wj.model.GMedicine;

public interface GMedicineService {

	public int addMedicine(GMedicine gMedicine) ;

	public List<GMedicine> findMedicine();

}
