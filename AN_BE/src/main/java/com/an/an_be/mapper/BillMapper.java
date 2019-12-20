package com.an.an_be.mapper;

import com.an.an_be.entity.AnBill;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @Author zhangan
 * @date: 2019/12/19
 */
public interface BillMapper {

    void addBill(AnBill entity)throws Exception;

    void deleteBill(Integer id)throws Exception;

    List<AnBill> getAllBill()throws Exception;

    void updateBill(AnBill entity)throws Exception;

    List<AnBill> getBillByCondition(Map<String,Object> param)throws Exception;

}
