package cn.edu.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.wj.model.GPayRecord;

public interface GPayRecordMapper {

	int insertSQL(GPayRecord gpay);
	
	List<GPayRecord> selectPayRecordInfo(int payNo);
	
	List<GPayRecord> findAllPayRecordInfo(int payNo);
	
	List<GPayRecord> selectPage(@Param("m")Integer m,@Param("n")Integer n,@Param("payNo")int payNo);
	
	int updateGPayRecordId(@Param("gpr")GPayRecord gpr, @Param("type")String type);

	int updateGPayRecord(int id);
}
