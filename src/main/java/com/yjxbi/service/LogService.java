package com.yjxbi.service;

import com.yjxbi.model.SysLog;
import com.yjxbi.commons.utils.PageInfo;

/**
 * @description：操作日志
 * @author：zhixuan.wang
 * @date：2015/10/30 10:35
 */
public interface LogService {

    void insertLog(SysLog sysLog);

    void findDataGrid(PageInfo pageInfo);
}
