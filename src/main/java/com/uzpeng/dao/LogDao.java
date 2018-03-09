package com.uzpeng.dao;

import com.uzpeng.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author serverliu on 2018/2/28.
 */
@Repository
public class LogDao {
    @Autowired
    private LogMapper logMapper;

    public void setLogMapper(LogMapper logMapper) {
        this.logMapper = logMapper;
    }

    public void insertLogRecord(String ip){
        logMapper.insertRecord(ip, new Date());
    }
}
