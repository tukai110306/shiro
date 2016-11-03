package com.yjxbi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjxbi.commons.annotation.DataSourceChange;
import com.yjxbi.commons.datasource.DbContextHolder;
import com.yjxbi.mapper.SlaveMapper;
import com.yjxbi.service.SlaveService;
@Service
public class SlaveServiceImpl implements SlaveService {

    @Autowired
    private SlaveMapper slaveMapper;

    @Override
    @DataSourceChange(slave = true)
    public Integer count() {
    	DbContextHolder.setDbType("2");
        return slaveMapper.count();
    }


}
