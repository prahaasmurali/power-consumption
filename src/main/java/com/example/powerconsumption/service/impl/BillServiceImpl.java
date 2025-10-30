package com.example.powerconsumption.service.impl;

import com.example.powerconsumption.dao.HouseDao;
import com.example.powerconsumption.model.House;
import com.example.powerconsumption.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private HouseDao houseDao;

    @Override
    public String getEscomForHouse(int houseId) {
        House house = houseDao.findById(houseId);
        return house != null ? house.getEscom() : null;
    }

    @Override
    public Map<String, Object> calculateBill(int houseId) {
        House house = houseDao.findById(houseId);
        Map<String, Object> result = new HashMap<>();
        if (house == null) {
            result.put("error", "House not found");
            return result;
        }
        double amount = 0.0;
        int units = house.getUnitsConsumed();
        String escom = house.getEscom();
        if ("CESCOM".equals(escom)) {
            if (units <= 50) {
                amount = 0;
            } else if (units <= 100) {
                amount = (units - 50) * 2;
            } else if (units <= 200) {
                amount = 50 * 2 + (units - 100) * 5;
            } else {
                amount = 50 * 2 + 100 * 5 + (units - 200) * 6.25;
            }
        } else if ("DESCOM".equals(escom)) {
            if (units <= 100) {
                amount = units * 1.5;
            } else if (units <= 200) {
                amount = 100 * 1.5 + (units - 100) * 4.75;
            } else {
                amount = 100 * 1.5 + 100 * 4.75 + (units - 200) * 6;
            }
        } else if ("FESCOM".equals(escom)) {
            amount = units * 3;
        }
        result.put("houseId", house.getId());
        result.put("escom", escom);
        result.put("units", units);
        result.put("amount", amount);
        return result;
    }
}
