package com.disaster.bean;

import lombok.Data;

/**
 * 存在数据库中的灾情信息
 */
@Data
public class Disaster {

    private String province;

    private String city;

    private String district;

    private String street;

    private String community;

    private String gmtTime;

    private String sourceType;

    private String sourceSubtype;

    private String carrier;

    private String disasterType;

    private String disasterSubtype;

    private String disasterIndex;
}