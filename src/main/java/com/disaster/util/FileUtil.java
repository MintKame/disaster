package com.disaster.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    /** 从File中读取code */
    public static List<String> getCode(MultipartFile file){
        List<String> codeList = null;
        // 获取文件后缀
        String fileName = file.getOriginalFilename();
        String suffix = StringUtil.suffixOfFileName(fileName);

        try (
                InputStream is =  file.getInputStream(); // 转成字符流
                ){
            // 根据文件类型读取code
            switch (suffix){
                case "txt":
                    codeList = parseTxt(is);
                    break;
                case "xlsx":
                case "xls":
                    codeList = parseExcel(is);
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return codeList;
    }

    /** 从txt文件读取code */
    private static List<String> parseTxt(InputStream is) throws IOException {
        List<String> codeList = new ArrayList<>();
        try (
                InputStreamReader isReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isReader);
        ) {
            //循环逐行读取
            while (br.ready()) {
                codeList.add(br.readLine());
            }
        }
        return codeList;
    }

    /** 从excel文件读取code */
    private static List<String> parseExcel(InputStream is) throws IOException {
        List<String> codeList = new ArrayList<>();
        //创建工作簿对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        //遍历工作簿中的所有数据
        //获取工作簿下sheet的个数
        int sheetNum = xssfWorkbook.getNumberOfSheets();
        for(int i = 0;i < sheetNum;i++) {
            // 读取第i个sheet
            XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
            // 获取最后一行的num，即总行数（此处从0开始）
            int maxRow = sheet.getLastRowNum();
            for (int row = 0; row <= maxRow; row++) {
                // 获取最后单元格num，即总单元格数（此处从1开始计数）
                int maxRol = sheet.getRow(row).getLastCellNum();
                for (int rol = 0; rol < maxRol; rol++){
                    codeList.add(sheet.getRow(row).getCell(rol) + "");
                }
            }
        }
        return codeList;
    }
}
