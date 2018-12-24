package cn.edu.wj.mapper;

import java.util.List;




import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import cn.edu.wj.model.ActionNode;

@Component
public interface ActionNodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActionNode record);

    int insertSelective(ActionNode record);

    ActionNode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActionNode record);

    int updateByPrimaryKey(ActionNode record);
    
    List<Map<String, Object>> selectAll(Integer roleId);

	List<Map<String, Object>> selectchildren(@Param("pid")Integer pid,@Param("roleId")Integer roleId);

	List<Map<String, Object>> selectBypid(int pid);

	List<Map<String, Object>> selectNode();

	List<Map<String, Object>> selectBypid2(Integer pid);
}