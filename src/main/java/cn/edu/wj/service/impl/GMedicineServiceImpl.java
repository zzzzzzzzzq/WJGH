package cn.edu.wj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wj.model.GMedicine;
import cn.edu.wj.model.GMedicineAllocation;
import cn.edu.wj.service.GMedicineService;
import cn.edu.wj.util.UIUtils;
import cn.edu.wj.mapper.GMedicineAllocationMapper;
import cn.edu.wj.mapper.GMedicineMapper;

@Service
public class GMedicineServiceImpl implements GMedicineService{
	@Autowired 
	GMedicineMapper GMedicineMapper;
	@Autowired 
	GMedicineAllocationMapper GMedicineAllocationMapper;
	
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

	public Map<String, Object> getUIGridDataMedicine(int page, int limit, Map<String, String> pageParams) {
		// TODO Auto-generated method stub
		int m=(page-1)*limit;
		int n=limit;
		List<GMedicine> list =GMedicineMapper.findMedicine();
		List<GMedicine> list2 =GMedicineMapper.selectPage(m,n);
		int count=list.size();
		int count2=list2.size();
		System.out.println(count2+"!!");
		System.out.println(list);
		System.out.println(count);
		return UIUtils.getGridData(count, list2);
	}

	@Override
	public int delMedicine(int mid) {
		// TODO Auto-generated method stub
		return GMedicineMapper.delMedicine(mid);
	}

	public Object getUIGridDataSaleMedicine(int page, int limit, Map<String, String> pageParams) {
		// TODO Auto-generated method stub
		int m=(page-1)*limit;
		int n=limit;
		int ifFinish = 0;
		List<GMedicineAllocation> list =GMedicineAllocationMapper.findUnfinishMedicine(ifFinish);
		List<GMedicineAllocation> list2 =GMedicineAllocationMapper.selectAllocation(m,n);
		int count=list.size();
		int count2=list2.size();
		System.out.println(count2+"!!");
		System.out.println(list);
		System.out.println(count);
		return UIUtils.getGridData(count, list2);
	}

	public Object getUIGridDataSelectMedicine(int page, int limit, Map<String, String> pageParams,int payno) {
		// TODO Auto-generated method stub
		int m=(page-1)*limit;
		int n=limit;
		int ifFinish = 0;
		List<GMedicineAllocation> list =GMedicineAllocationMapper.findPayMedicine(ifFinish,payno);
		List<GMedicineAllocation> list2 =GMedicineAllocationMapper.selectPageAllocation(m,n,ifFinish,payno);
		int count=list.size();
		int count2=list2.size();
		System.out.println(count2+"!!");
		System.out.println(list+"test");
		System.out.println(count);
		return UIUtils.getGridData(count, list2);
	}


	@Override
	public int finishMedicine(GMedicineAllocation record) {
		// TODO Auto-generated method stub
		return GMedicineAllocationMapper.finishMedicine(record);
	}

	public Object getUIGridDatafindMedicine(int page, int limit, Map<String, String> pageParams, String mName) {
		// TODO Auto-generated method stub
		int m=(page-1)*limit;
		int n=limit;
		List<GMedicine> list =GMedicineMapper.findMedicinebyName(mName);
		List<GMedicine> list2 =GMedicineMapper.selectPagebyName(m,n,mName);
		int count=list.size();
		int count2=list2.size();
		System.out.println(count2+"!!");
		System.out.println(list);
		System.out.println(count);
		return UIUtils.getGridData(count, list2);
	}
	
}
