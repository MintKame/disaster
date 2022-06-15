package com.disaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnalyzeController {

    @GetMapping("/analyze")
    String toAnalyze(){
        return "analyze";
    }
}
