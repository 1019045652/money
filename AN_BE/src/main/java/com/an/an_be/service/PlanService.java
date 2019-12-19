package com.an.an_be.service;

import com.an.an_be.entity.Plan;

import java.util.List;

public interface PlanService {
    void savePlan(Plan plan) throws Exception;
    List<Plan> findAllPlan() throws Exception;
}
