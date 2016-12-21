package com.yjxbi.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjxbi.commons.utils.PageInfo;
import com.yjxbi.service.SlaveService;

/**
 * @description：流程统计
 * @author：tukai
 * @date：2015/10/30 18:06
 */
@Controller
@RequestMapping("/oaflow")
public class OaFlowController {

    @Autowired
    private SlaveService slaveService;


    @RequestMapping(value = "/hrmresource", method = RequestMethod.GET)
    public String hrmresource() {
        return "/oa/hrmresource";
    }
    
    @RequestMapping(value = "/assigntask", method = RequestMethod.GET)
    public String assigntask() {
        return "/oa/assigntask";
    }


    @RequestMapping(value = "/hrmresourceGrid", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo dataGrid(Integer page, Integer rows,String userId,String createdateStart,String createdateEnd) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        if (StringUtils.isNoneBlank(userId)) {
            condition.put("userId", userId);
        }
        if (StringUtils.isNoneBlank(createdateStart)) {
            condition.put("createdateStart", createdateStart);
        }
        if (StringUtils.isNoneBlank(createdateEnd)) {
            condition.put("createdateEnd", createdateEnd);
        }
        pageInfo.setCondition(condition);
        slaveService.queryHrmreSourceGrid(pageInfo);
        return pageInfo;
    }
    
    @RequestMapping(value = "/assigntaskGrid", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo assigntaskGrid(Integer page, Integer rows,String userId,String createdateStart,String createdateEnd) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        if (StringUtils.isNoneBlank(userId)) {
            condition.put("userId", userId);
        }
        if (StringUtils.isNoneBlank(createdateStart)) {
            condition.put("createdateStart", createdateStart);
        }
        if (StringUtils.isNoneBlank(createdateEnd)) {
            condition.put("createdateEnd", createdateEnd);
        }
        pageInfo.setCondition(condition);
        slaveService.queryAssignTaskGrid(pageInfo);
        return pageInfo;
    }
    
    @RequestMapping(value = "/needUserList", method = RequestMethod.POST)
    @ResponseBody
    public Object tree() {
        return slaveService.queryTree();
    }
    
    /**
     * 人员部门树
     *
     * @return
     */
    @RequestMapping(value = "/allUserTree", method = RequestMethod.POST)
    @ResponseBody
    public Object allUserTree(String departmentId) {
    	if(departmentId == null || StringUtils.isBlank(departmentId)){
    		return slaveService.queryAllDepartmentTree();
    	}else{
    		return slaveService.queryAllUserTree(departmentId);
    	}
        
    }
}
