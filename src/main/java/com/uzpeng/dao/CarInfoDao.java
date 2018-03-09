package com.uzpeng.dao;

import com.uzpeng.domain.CarInfoDO;
import com.uzpeng.mapper.CarInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author serverliu on 2018/2/26.
 */
@Repository
public class CarInfoDao {
    @Autowired
    private CarInfoMapper carInfoMapper;

    public void setCarInfoMapper(CarInfoMapper carInfoMapper) {
        this.carInfoMapper = carInfoMapper;
    }

    public List<CarInfoDO> getCarInfo(int limit, int offset){
        return carInfoMapper.getCarInfo(limit, offset);
    }
}
