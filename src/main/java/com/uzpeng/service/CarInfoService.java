package com.uzpeng.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uzpeng.dao.CarInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author serverliu on 2018/2/26.
 */
@Service
public class CarInfoService {
    @Autowired
    private CarInfoDao carInfoDao;

    public void setCarInfoDao(CarInfoDao carInfoDao) {
        this.carInfoDao = carInfoDao;
    }

    public String getCarInfo(int limit, int offset){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(carInfoDao.getCarInfo(limit, offset));
    }
}
