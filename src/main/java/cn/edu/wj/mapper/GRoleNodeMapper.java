package cn.edu.wj.mapper;

import cn.edu.wj.model.GRoleNode;

public interface GRoleNodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GRoleNode record);

    int insertSelective(GRoleNode record);

    GRoleNode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GRoleNode record);

    int updateByPrimaryKey(GRoleNode record);
}