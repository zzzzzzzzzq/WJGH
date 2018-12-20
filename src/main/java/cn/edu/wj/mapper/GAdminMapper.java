package cn.edu.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.wj.model.GAdmin;



public interface GAdminMapper {
    int findId(String loginName);

	int deleteByPrimaryKey(Integer id);

    int insert(GAdmin record);

    int insertSelective(GAdmin record);

    GAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GAdmin record);

    int updateByPrimaryKey(GAdmin record);

	List<GAdmin> findGAdmin();
	
	int insertSQL(GAdmin gad);
	
	List<GAdmin> selectPage(@Param("m")Integer m,@Param("n")Integer n);

	List<GAdmin> checkLogin(GAdmin gad);

	List<GAdmin> findByLoginName(String loginName);

	boolean ifDisable(String loginName);
	
	
}