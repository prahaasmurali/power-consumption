package com.example.powerconsumption.service;

import java.util.Map;

public interface BillService {
    String getEscomForHouse(int houseId);
    Map<String, Object> calculateBill(int houseId);
}
