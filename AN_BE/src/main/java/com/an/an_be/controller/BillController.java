package com.an.an_be.controller;

import com.alibaba.fastjson.JSONObject;
import com.an.an_be.entity.Result;
import com.an.an_be.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Author zhangan
 * @date: 2019/12/19
 */
@RestController
public class BillController {

    @Autowired
    private BillService billService;
    /**
     * 获取所有账单列表
     * */
    @GetMapping(value="/getAllBill")
    public Result getAllBill(){
        JSONObject result = new JSONObject();
        try{
            return new Result(200,"操作成功",true, billService.getAllBill());

        }catch (Exception e){
            e.printStackTrace();
            return new Result(404,"系统错误",false);
        }
    }
}
