package cn.edu.wj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wj.mapper.GOrdinaryCherkMapper;
import cn.edu.wj.model.GMedicine;
import cn.edu.wj.model.GMedicineAllocation;
import cn.edu.wj.model.GOrdinaryCherk;
import cn.edu.wj.service.GOrdinaryService;
import cn.edu.wj.util.UIUtils;
@Service
public class GOrdinaryServiceImpl implements GOrdinaryService{
	@Autowired
	GOrdinaryCherkMapper GOrdinaryCherkMapper;

	public Object getUIGridDataAllOrdinary(int page, int limit, Map<String, String> pageParams) {
		// TODO Auto-generated method stub
		int m=(page-1)*limit;
		int n=limit;
		List<GOrdinaryCherk> list =GOrdinaryCherkMapper.findAllOrdinary();
		List<GOrdinaryCherk> list2 =GOrdinaryCherkMapper.selectPage(m,n);
		int count=list.size();
		int count2=list2.size();
		System.out.println(count2+"!!");
		System.out.println(list);
		System.out.println(count);
		return UIUtils.getGridData(count, list2);
	}

	public Object getUIGridDatafindOrdinary(int page, int limit, Map<String, String> pageParams, int opayno) {
		// TODO Auto-generated method stub
		int m=(page-1)*limit;
		int n=limit;
		int ifFinish = 0;
		List<GMedicineAllocation> list =GOrdinaryCherkMapper.findUnFOrdinary(ifFinish,opayno);
		List<GMedicineAllocation> list2 =GOrdinaryCherkMapper.selectPageUnFOrdinary(m,n,ifFinish,opayno);
		int count=list.size();
		int count2=list2.size();
		System.out.println(count2+"!!");
		System.out.println(list+"test");
		System.out.println(count);
		return UIUtils.getGridData(count, list2);
	}

	@Override
	public int finishOrdinary(GOrdinaryCherk record) {
		// TODO Auto-generated method stub
		return GOrdinaryCherkMapper.finishOrdinary(record);
	}

}
