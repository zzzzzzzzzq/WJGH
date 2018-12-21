package cn.edu.wj.mapper;

import org.apache.ibatis.annotations.Param;

import cn.edu.wj.model.RoleNode;


public interface RoleNodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleNode record);

    int insertSelective(RoleNode record);

    RoleNode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleNode record);

    int updateByPrimaryKey(RoleNode record);

	int findByRoleId(@Param("roleId")Integer roleId, @Param("nodeId")Integer nodeId);
}