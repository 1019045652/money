package com.an.an_be.controller;

import com.alibaba.fastjson.JSONObject;
import com.an.an_be.entity.Plan;
import com.an.an_be.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class PlanController {
    @Autowired
    private PlanService planService;

    @ResponseBody
    @RequestMapping(value = "/savePlan",method = RequestMethod.POST)
    public JSONObject savePlan(Plan plan){
        JSONObject json = new JSONObject();
        try {
            plan.setPlanId(new Date().toString()+Math.random());
            plan.setPlanCreateTime(new Date());
            plan.setPlanIsEnd(false);
            planService.savePlan(plan);
            json.put("code","200");
        } catch (Exception e) {
            e.printStackTrace();
            json.put("code","401");
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/findAllPlan")
    public JSONObject findAllPlan(){
        JSONObject json = new JSONObject();
        try {
            List<Plan> planList =  planService.findAllPlan();
            json.put("planList",planList);
            json.put("code","200");
        } catch (Exception e) {
            e.printStackTrace();
            json.put("code","401");
        }
        return json;
    }
}
