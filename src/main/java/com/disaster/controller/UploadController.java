package com.disaster.controller;

import com.disaster.bean.Disaster;
import com.disaster.service.DisasterService;
import com.disaster.util.FileUtil;
import com.disaster.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UploadController {

    @Autowired
    DisasterService disasterService;

    @GetMapping("/upload")
    String toUpload(){
        return "upload";
    }

    @PostMapping("/upload/code")
    String uploadCode(String code){ // todo 检查code正确
        disasterService.addByCode(code);
        return "redirect:/upload";
    }

    @PostMapping("/upload/file")
    String uploadFile(MultipartFile file){
        // 从文件中解析出code
        List<String> code = FileUtil.getCode(file);
        // 解析并添加code
        for (String s : code) {
            disasterService.addByCode(s);
        }
        return "redirect:/upload";
    }
}
