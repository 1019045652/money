package com.an.an_be.controller;


import com.an.an_be.util.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelController {
    @RequestMapping("/exe")
    public void testExcel2(HttpServletResponse response) {
        //创建报表数据头
        List<String> head = new ArrayList<>();
        head.add("学号");
        head.add("姓名");
        head.add("性别");

        //创建报表体
        List<List<String>> body = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> dataList = new ArrayList<>();
            dataList.add("270215013" + i);
            dataList.add("mary");
            dataList.add("男");
            body.add(dataList);
        }
        String fileName = "学生信息统计.xls";
        HSSFWorkbook excel = ExcelUtils.expExcel(head, body);
        ExcelUtils.outFile(excel, "./" + fileName, response);
    }
}

