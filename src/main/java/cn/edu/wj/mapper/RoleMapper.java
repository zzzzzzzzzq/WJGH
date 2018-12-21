package cn.edu.wj.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import cn.edu.wj.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	List<Role> selectAll();
	
	List<Role> selectPage(@Param("m")Integer m,@Param("n")Integer n);
}