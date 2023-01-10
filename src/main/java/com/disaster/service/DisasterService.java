package com.disaster.service;

import com.disaster.bean.Disaster;
import com.disaster.bean.Province;
import com.disaster.mapper.AttrMapper;
import com.disaster.mapper.DisasterMapper;
import com.disaster.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class DisasterService {

    @Autowired
    DisasterMapper disasterMapper;

    @Autowired
    AttrMapper attrMapper;

    // 解码并添加code
    public void addByCode(String code){
        Disaster disaster = new Disaster();
        // addr
        disaster.setProvince(attrMapper.getAddr(code.substring(0, 2) + "0000000000"));
        disaster.setCity(attrMapper.getAddr(code.substring(0, 4) + "00000000"));
        disaster.setDistrict(attrMapper.getAddr(code.substring(0, 6) + "000000"));
        disaster.setStreet(attrMapper.getAddr(code.substring(0, 9) + "000"));
        disaster.setCommunity(attrMapper.getAddr(code.substring(0, 12)));
        // time
        try {
            disaster.setGmtTime(TimeUtil.gmtCode2Time(code.substring(12, 26)));
        } catch (ParseException e) {
            e.printStackTrace();
            // todo 处理错误
        }
        // source
        String sourceTypeCode = code.substring(26, 27);
        disaster.setSourceType(attrMapper.getSourceType(sourceTypeCode));
        disaster.setSourceSubtype(attrMapper.getSourceSubType(sourceTypeCode, code.substring(27, 29)));
        // carrier
        disaster.setCarrier(attrMapper.getCarrier(code.substring(29, 30)));
        // disaster
        String disasterTypeCode = code.substring(30, 31);
        disaster.setDisasterType(attrMapper.getDisasterType(disasterTypeCode));
        disaster.setDisasterSubtype(attrMapper.getDisasterSubType(disasterTypeCode, code.substring(31, 33)));
        disaster.setDisasterIndex(attrMapper.getDisasterIndex(disasterTypeCode, code.substring(33, 36)));
        disasterMapper.addDisaster(disaster);
    }

    // 查询所有灾情信息
    public List<Disaster> getAll() {
        return disasterMapper.getAll();
    }

    // 获取每个省的灾情信息数量
    public List<Province> getProvinceCnt() {
        return disasterMapper.getProvinceCnt();
    }
}
