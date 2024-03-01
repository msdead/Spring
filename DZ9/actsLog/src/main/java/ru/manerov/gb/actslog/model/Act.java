package ru.manerov.gb.actslog.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Act {

    private int id;
    private String reportingPeriod;
    private String projectSection;
    private double price;
    private String status;

}
