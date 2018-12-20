package cn.edu.wj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.edu.wj.model.GNode;

public interface GNodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GNode record);

    int insertSelective(GNode record);

    GNode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GNode record);

    int updateByPrimaryKey(GNode record);

	List<Map<String, Object>> selectAll(Integer roleId);

	List<Map<String, Object>> selectchildren(@Param("pid")int pid, @Param("roleId")Integer roleId);
}