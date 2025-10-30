package com.example.powerconsumption.dao.impl;

import com.example.powerconsumption.dao.HouseDao;
import com.example.powerconsumption.model.House;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class HouseDaoImpl implements HouseDao {
    private final Map<Integer, House> houseMap = new HashMap<>();
    private static final String[] ESCOMS = {"CESCOM", "DESCOM", "FESCOM"};

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 100; i++) {
            String escom = ESCOMS[ThreadLocalRandom.current().nextInt(ESCOMS.length)];
            int units = ThreadLocalRandom.current().nextInt(0, 301);
            houseMap.put(i, new House(i, escom, units));
        }
    }

    @Override
    public House findById(int id) {
        return houseMap.get(id);
    }

    @Override
    public List<House> findAll() {
        return new ArrayList<>(houseMap.values());
    }
}
