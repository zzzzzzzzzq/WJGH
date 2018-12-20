package cn.edu.wj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wj.mapper.GPayRecordMapper;
import cn.edu.wj.model.GPayRecord;
import cn.edu.wj.service.GPayRecordService;

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
}
