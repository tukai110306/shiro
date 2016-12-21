package com.yjxbi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjxbi.commons.annotation.DataSourceChange;
import com.yjxbi.commons.datasource.DbContextHolder;
import com.yjxbi.commons.result.Tree;
import com.yjxbi.commons.utils.PageInfo;
import com.yjxbi.mapper.SlaveMapper;
import com.yjxbi.model.Role;
import com.yjxbi.service.SlaveService;
@Service
public class SlaveServiceImpl implements SlaveService {

    @Autowired
    private SlaveMapper slaveMapper;

    @Override
    @DataSourceChange(slave = true)
    public List queryHrmreSource(PageInfo pageInfo) {
    	DbContextHolder.setDbType("2");
        return slaveMapper.queryHrmreSource(pageInfo);
    }
    
    @Override
    @DataSourceChange(slave = true)
    public void queryHrmreSourceGrid(PageInfo pageInfo) {
    	DbContextHolder.setDbType("2");
    	pageInfo.setRows(slaveMapper.queryHrmreSource(pageInfo));
        pageInfo.setTotal(slaveMapper.queryHrmreSourceCount(pageInfo));
    }
    
    @Override
    @DataSourceChange(slave = true)
    public void queryAssignTaskGrid(PageInfo pageInfo) {
    	DbContextHolder.setDbType("2");
    	pageInfo.setRows(slaveMapper.queryAssignTask(pageInfo));
        pageInfo.setTotal(slaveMapper.queryAssignTaskCount(pageInfo));
    }
    
    @Override
    @DataSourceChange(slave = true)
    public List<Tree> queryTree() {
    	DbContextHolder.setDbType("2");//指定用哪个库，但是对于切面事物该方法切库不会成功
        List<Tree> trees = new ArrayList<Tree>();
        List<Role> roles = slaveMapper.queryNeedUser();
        for (Role role : roles) {
            Tree tree = new Tree();
            tree.setId(role.getId().toString());
            tree.setText(role.getName());
            trees.add(tree);
        }
        return trees;
    }
    
    @Override
    @DataSourceChange(slave = true)
    public List<Tree> queryAllDepartmentTree() {
    	DbContextHolder.setDbType("2");
        List<Tree> trees = new ArrayList<Tree>();

        List<Role> departmentFather = slaveMapper.findAllDepartment();

        if (departmentFather != null) {
            for (Role role : departmentFather) {
                Tree treeOne = new Tree();

                treeOne.setId(role.getId().toString());
                treeOne.setText(role.getName());
                treeOne.setIconCls("icon-folder");

                /*List<Role> userSon = slaveMapper.findAllUserByDeparmentid(role.getId());

                if (userSon != null) {
                    List<Tree> tree = new ArrayList<Tree>();
                    for (Role user : userSon) {
                        Tree treeTwo = new Tree();
                        treeTwo.setId(user.getId());
                        treeTwo.setText(user.getName());
                        treeTwo.setIconCls("icon-company");
                        tree.add(treeTwo);
                    }
                    treeOne.setChildren(tree);
                } else {
                    treeOne.setState("closed");
                }*/
                treeOne.setState("closed");
                trees.add(treeOne);
            }
        }
        return trees;
    }

    @Override
    @DataSourceChange(slave = true)
    public List<Tree> queryAllUserTree(String departmentId) {
    	DbContextHolder.setDbType("2");
    	List<Tree> trees = new ArrayList<Tree>();
    	List<Role> userSon = slaveMapper.findAllUserByDeparmentid(Long.parseLong(departmentId));

        if (userSon != null) {
            List<Tree> tree = new ArrayList<Tree>();
            for (Role user : userSon) {
                Tree treeTwo = new Tree();
                treeTwo.setId(user.getId().toString());
                treeTwo.setText(user.getName());
                treeTwo.setIconCls("icon-company");
                trees.add(treeTwo);
            }
        }
        return trees;
    }

}
