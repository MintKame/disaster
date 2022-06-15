package com.disaster.controller;

import com.disaster.bean.Province;
import com.disaster.service.DisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class AnalyzeController {

    @Autowired
    DisasterService disasterService;

    @GetMapping("/analyze")
    String toAnalyze(Model model){
        List<Province> addrCnt = disasterService.getProvinceCnt();
        for (Province province : addrCnt) {
            model.addAttribute(Province.getAbbr(province.getName()), province.getCnt());
        }
        return "analyze";
    }
}
