package com.an.an_be.service.impl;

import com.an.an_be.entity.AnBill;
import com.an.an_be.mapper.BillMapper;
import com.an.an_be.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 账单service
 * @Author zhangan
 * @date: 2019/12/19
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    public void addBill(AnBill entity) throws Exception {
        billMapper.addBill(entity);
    }

    public void updateBill(AnBill entity) throws Exception {
        billMapper.updateBill(entity);
    }

    public void deleteBill(Integer id) throws Exception {
        billMapper.deleteBill(id);
    }

    public List<AnBill> getAllBill() throws Exception {
        return  billMapper.getAllBill();
    }
}
