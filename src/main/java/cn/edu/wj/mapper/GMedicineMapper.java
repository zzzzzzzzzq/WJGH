package cn.edu.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.wj.model.GMedicine;

public interface GMedicineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GMedicine record);

    int insertSelective(GMedicine record);

    GMedicine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GMedicine record);

    int updateByPrimaryKey(GMedicine record);

	int addMedicine(GMedicine gMedicine);

	List<GMedicine> findMedicine();

	List<GMedicine> selectPage(@Param("m")int m,@Param("n")int n);
	
//	List<GMedicine> selectPageAllocation(@Param("m")int m,@Param("n")int n);
	
	int delMedicine(int mid);

//	List<GMedicine> findUnfinishMedicine(int ifFinish);
}