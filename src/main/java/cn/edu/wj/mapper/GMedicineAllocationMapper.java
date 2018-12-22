package cn.edu.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.wj.model.GMedicineAllocation;

public interface GMedicineAllocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GMedicineAllocation record);

    int insertSelective(GMedicineAllocation record);

    GMedicineAllocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GMedicineAllocation record);

    int updateByPrimaryKey(GMedicineAllocation record);

	List<GMedicineAllocation> findUnfinishMedicine(int ifFinish);

	List<GMedicineAllocation> selectPageAllocation(@Param("m")int m,@Param("n")int n,@Param("i")int ifFinish,@Param("p")int payno);

	List<GMedicineAllocation> findPayMedicine(@Param("i")int ifFinish,@Param("p")int payno);

	int finishMedicine(GMedicineAllocation record);

}