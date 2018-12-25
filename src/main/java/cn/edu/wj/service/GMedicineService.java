package cn.edu.wj.service;

import java.util.List;

import cn.edu.wj.model.GMedicine;
import cn.edu.wj.model.GMedicineAllocation;

public interface GMedicineService {

	public int addMedicine(GMedicine gMedicine) ;

	public List<GMedicine> findMedicine();

	public int delMedicine(int mid);

	public int finishMedicine(GMedicineAllocation record);
	
	public int insert(GMedicineAllocation gma);

}
