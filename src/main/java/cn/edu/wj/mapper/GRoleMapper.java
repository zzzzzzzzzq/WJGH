package cn.edu.wj.mapper;

import cn.edu.wj.model.GRole;

public interface GRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GRole record);

    int insertSelective(GRole record);

    GRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GRole record);

    int updateByPrimaryKey(GRole record);
}