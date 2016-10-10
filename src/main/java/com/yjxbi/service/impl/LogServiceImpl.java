package com.yjxbi.service.impl;

import com.yjxbi.mapper.SysLogMapper;
import com.yjxbi.model.SysLog;
import com.yjxbi.service.LogService;
import com.yjxbi.commons.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description：
 * @author：zhixuan.wang
 * @date：2015/10/30 10:40
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void insertLog(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }

    @Override
    public void findDataGrid(PageInfo pageInfo) {
        pageInfo.setRows(sysLogMapper.findDataGrid(pageInfo));
        pageInfo.setTotal(sysLogMapper.findDataGridCount(pageInfo));
    }
}
