package cn.edu.wj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wj.mapper.GPayRecordMapper;
import cn.edu.wj.model.GPayRecord;
import cn.edu.wj.service.GPayRecordService;
import cn.edu.wj.util.UIUtils;

@Service
public class GPayRecordServiceImpl implements GPayRecordService {

	@Autowired
	private GPayRecordMapper gpayMapper;
	
	@Override
	public int insert(GPayRecord gpay){
		// TODO Auto-generated method stub
				int result2 =gpayMapper.insertSQL(gpay);
				return 0;
	}

	@Override
	public List<GPayRecord> selectPayRecordInfo(int payNo) {
		// TODO Auto-generated method stub
		return gpayMapper.selectPayRecordInfo(payNo);
	}
	
	public Map<String, Object> getUIGridData1(int payNo,int page,int limit,Map<String, String> pageMap) {
		int m=(page-1)*limit;
		int n=limit;
		List<GPayRecord> list=gpayMapper.findAllPayRecordInfo(payNo);
		List<GPayRecord> list2=gpayMapper.selectPage(m,n,payNo);
		int count=list.size();
		int count2=list2.size();
		System.out.println(count2+"!!");
		System.out.println(list);
		System.out.println(count);
		return UIUtils.getGridData(count, list2);
	}

	@Override
	public int updateGPayRecordId(GPayRecord gpay, String type) {
		// TODO Auto-generated method stub
		System.out.println(gpay.getDoctor());
		System.out.println(gpay.getPayWay());
		return gpayMapper.updateGPayRecordId(gpay, type);
	}

	@Override
	public int updateGPayRecord(int id) {
		// TODO Auto-generated method stub
		return gpayMapper.updateGPayRecord(id);
	}
}
