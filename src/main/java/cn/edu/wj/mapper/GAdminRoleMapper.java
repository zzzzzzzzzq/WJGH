package cn.edu.wj.mapper;

import cn.edu.wj.model.GAdminRole;

public interface GAdminRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GAdminRole record);

    int insertSelective(GAdminRole record);

    GAdminRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GAdminRole record);

    int updateByPrimaryKey(GAdminRole record);

	int findRoleId(int userId);
}