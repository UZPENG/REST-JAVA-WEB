package com.uzpeng.service;

import com.uzpeng.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author serverliu on 2018/2/28.
 */
@Service
public class LogService {
    @Autowired
    private LogDao logDao;

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public void insertLog(String ip){
        logDao.insertLogRecord(ip);
    }
}
