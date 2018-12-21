package cn.edu.wj.mapper;

import cn.edu.wj.model.GMedicineAllocation;

public interface GMedicineAllocationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GMedicineAllocation record);

    int insertSelective(GMedicineAllocation record);

    GMedicineAllocation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GMedicineAllocation record);

    int updateByPrimaryKey(GMedicineAllocation record);
}