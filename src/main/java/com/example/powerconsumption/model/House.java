package com.example.powerconsumption.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
    private int id;
    private String escom;
    private int unitsConsumed;
}
