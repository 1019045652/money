package com.an.an_be.service.impl;

import com.an.an_be.entity.Plan;
import com.an.an_be.mapper.PlanMapper;
import com.an.an_be.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PlanServiceImpl")
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanMapper planMapper;
    @Override
    public void savePlan(Plan plan) throws Exception{
        planMapper.savePlan(plan);
    }

    @Override
    public List<Plan> findAllPlan() throws Exception {
        return planMapper.findAllPlan();
    }
}
