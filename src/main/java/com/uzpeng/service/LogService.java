package com.uzpeng.service;

import com.uzpeng.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author serverliu on 2018/2/28.
 */
@Service
@Transactional
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
