package cn.edu.wj.mapper;

import java.util.List;

import cn.edu.wj.model.GPatientInfo;

public interface GPatientInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GPatientInfo record);

    int insertSelective(GPatientInfo record);

    GPatientInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GPatientInfo record);

    int updateByPrimaryKey(GPatientInfo record);

	List<GPatientInfo> findPatient(String patientIden);

	List<GPatientInfo> selectPatientInfo(String patientIden);
	
	String selectPatientIdentityid(int patientcardId);

	
	int selectPatientId(String patientIdentityid);
	GPatientInfo findPinfo(int opayno);
}
