package com.example.powerconsumption.dao;

import com.example.powerconsumption.model.House;
import java.util.List;

public interface HouseDao {
    House findById(int id);
    List<House> findAll();
}
