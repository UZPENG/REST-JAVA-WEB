package com.uzpeng.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author serverliu on 2018/2/28.
 */
public interface LogMapper {
    @Insert("INSERT INTO log(ip, date_time) values(#{ip}, #{dateTime,jdbcType=TIMESTAMP})")
    void insertRecord(@Param("ip")String ip, @Param("dateTime")Date dateTime);
}
