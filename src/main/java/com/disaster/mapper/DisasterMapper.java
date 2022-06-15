package com.disaster.mapper;

import com.disaster.bean.Disaster;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DisasterMapper {

    void addDisaster(Disaster disaster);

    List<Disaster> getAll();
}
