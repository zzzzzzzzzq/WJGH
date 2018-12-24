package cn.edu.wj.service;

import java.util.List;

import cn.edu.wj.model.GPayRecord;

public interface GPayRecordService {

	int insert(GPayRecord gpay);
	
	List<GPayRecord> selectPayRecordInfo(int payNo);
	
	int updateGPayRecordId(GPayRecord gpay,String type);
	
	int updateGPayRecord(int id);
}
