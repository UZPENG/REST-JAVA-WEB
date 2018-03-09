package com.uzpeng.mapper;

import com.uzpeng.domain.CarInfoDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author serverliu on 2018/2/26.
 */
public interface CarInfoMapper {
    @Select("select * from guazi limit #{limit} offset #{offset}")
    List<CarInfoDO> getCarInfo(@Param("limit")int limit, @Param("offset") int offset);
}
