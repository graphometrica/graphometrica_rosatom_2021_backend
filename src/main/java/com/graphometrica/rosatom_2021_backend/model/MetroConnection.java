package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;

@Data
public class MetroConnection {

    private String id;
    private int stationIdA;
    private int stationIdB;
    private String stationA;
    private String stationB;
    private Boolean inside;
    private int time;

}
