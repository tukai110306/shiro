package com.yjxbi.mapper;

import java.util.List;

import com.yjxbi.commons.utils.PageInfo;
import com.yjxbi.model.AssignTask;
import com.yjxbi.model.HrmreSource;
import com.yjxbi.model.Role;

public interface SlaveMapper {
	List<HrmreSource> queryHrmreSource(PageInfo pageInfo);
	
	int queryHrmreSourceCount(PageInfo pageInfo);
	
	List<AssignTask> queryAssignTask(PageInfo pageInfo);
	
	int queryAssignTaskCount(PageInfo pageInfo);
	
	List<Role> queryNeedUser();
	
	List<Role> findAllDepartment();
	
	List<Role> findAllUserByDeparmentid(Long pid);

}
