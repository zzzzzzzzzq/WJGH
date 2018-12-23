package cn.edu.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.wj.model.GMedicine;
import cn.edu.wj.model.GMedicineAllocation;
import cn.edu.wj.model.GOrdinaryCherk;

public interface GOrdinaryCherkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GOrdinaryCherk record);

    int insertSelective(GOrdinaryCherk record);

    GOrdinaryCherk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GOrdinaryCherk record);

    int updateByPrimaryKey(GOrdinaryCherk record);

	List<GOrdinaryCherk> findAllOrdinary();

	List<GOrdinaryCherk> selectPage(@Param("m")int m, @Param("n")int n);

	List<GMedicineAllocation> findUnFOrdinary(@Param("if")int ifFinish,@Param("p") int opayno);

	List<GMedicineAllocation> selectPageUnFOrdinary(@Param("m")int m, @Param("n")int n, @Param("if")int ifFinish,@Param("p") int opayno);

	int finishOrdinary(GOrdinaryCherk record);
}