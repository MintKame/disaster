package com.disaster.controller;

import com.disaster.bean.Disaster;
import com.disaster.service.DisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    DisasterService disasterService;

    @GetMapping("/search")
    String toSearch(Model model){
        // 获取所有disaster
        List<Disaster> disasters = disasterService.getAll();
        model.addAttribute("disasters", disasters);
        return "search";
    }

    @PostMapping("/search/msg")
    String searchByMsg(Model model, Disaster disaster){
        // 获取所有disaster
        List<Disaster> disasters = disasterService.getAll();
        model.addAttribute("disasters", disasters);
        return "search";
    }

}
