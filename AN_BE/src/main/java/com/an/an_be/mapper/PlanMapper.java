package com.an.an_be.mapper;

import com.an.an_be.entity.Plan;

import java.util.List;

public interface PlanMapper {
    void savePlan(Plan plan) throws Exception;
    List<Plan> findAllPlan() throws Exception;
}
