package com.example.powerconsumption.controller;

import com.example.powerconsumption.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/houses/{id}")
    public Map<String, Object> getHouseEscom(@PathVariable int id) {
        String escom = billService.getEscomForHouse(id);
        Map<String, Object> response = new HashMap<>();
        response.put("houseId", id);
        response.put("escom", escom);
        return response;
    }

    @GetMapping("/bill/{id}")
    public Map<String, Object> getBill(@PathVariable int id) {
        return billService.calculateBill(id);
    }
}
