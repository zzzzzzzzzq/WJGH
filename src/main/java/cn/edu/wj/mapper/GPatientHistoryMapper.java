package cn.edu.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.wj.model.GPatientHistory;


public interface GPatientHistoryMapper {

	List<GPatientHistory> findGPatientHistory(String patientIdentityid);
	
	List<GPatientHistory> findAllGPatientHistory(String patientIdentityid);
	
	List<GPatientHistory> selectPage(@Param("m")Integer m,@Param("n")Integer n,@Param("patientIdentityid")String patientIdentityid);
	
	int updateGPatientHistory(GPatientHistory gph);
	
}
