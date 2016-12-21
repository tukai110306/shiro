package com.yjxbi.service;

import java.util.List;

import com.yjxbi.commons.result.Tree;
import com.yjxbi.commons.utils.PageInfo;

public interface SlaveService {

    List queryHrmreSource(PageInfo pageInfo);
    
    void queryHrmreSourceGrid(PageInfo pageInfo);
    
    List<Tree> queryTree();
    
    void queryAssignTaskGrid(PageInfo pageInfo);
    
    List<Tree> queryAllDepartmentTree();
    
    List<Tree> queryAllUserTree(String departmentId);

}
