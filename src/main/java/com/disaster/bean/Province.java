package com.disaster.bean;

import lombok.Data;

import java.util.HashMap;

/**
 * dto，传给前端每个省的灾情信息数量，用于显示地图
 */
@Data
public class Province {
    String name;

    Integer cnt;

    // 省份对应的缩写
    private static HashMap<String, String> map = new HashMap<>();
    static {
        map.put("北京市","BJ");
        map.put("天津市","TJ");
        map.put("上海市","SH");
        map.put("重庆市","CQ");
        map.put("河北省","HB");
        map.put("河南省","HN");
        map.put("云南省","YN");
        map.put("辽宁省","LN");
        map.put("黑龙江省","HLJ");
        map.put("湖南省","HN");
        map.put("安徽省","AH");
        map.put("山东省","SD");
        map.put("新疆维吾尔自治区","XJ");
        map.put("江苏省","JS");
        map.put("浙江省","ZJ");
        map.put("江西省","JX");
        map.put("湖北省","HB");
        map.put("广西壮族自治区","GX");
        map.put("甘肃省","GS");
        map.put("山西省","SX");
        map.put("内蒙古自治区","NMG");
        map.put("陕西省","SX");
        map.put("吉林省","JL");
        map.put("福建省","FJ");
        map.put("贵州省","GZ");
        map.put("广东省","GD");
        map.put("青海省","QH");
        map.put("西藏自治区","XZ");
        map.put("四川省","SC");
        map.put("宁夏回族自治区","NX");
        map.put("海南省","HN");
        map.put("台湾省","TW");
        map.put("香港特别行政区","HK");
        map.put("澳门特别行政区","AM");
    }

    public static String getAbbr(String key){
        return map.get(key);
    }

}
