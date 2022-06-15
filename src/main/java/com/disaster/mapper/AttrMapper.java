package com.disaster.mapper;

import com.disaster.bean.Disaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttrMapper {
    String getAddr(String code);

    String getSourceType(String code);

    String getSourceSubType(@Param("sourceType") String sourceType, @Param("sourceSubtype")String sourceSubtype);

    String getCarrier(String code);

    String getDisasterType(String code);

    String getDisasterSubType(@Param("disasterType")String disasterType,@Param("disasterSubtype")String disasterSubtype);

    String getDisasterIndex(@Param("disasterType")String disasterType,@Param("disasterIndex") String disasterIndex);
}
