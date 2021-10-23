package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;

import java.util.Map;

@Data
public class StationConnection {

    private String id;
    private long stationIdA;
    private long stationIdB;
    private String stationA;
    private String stationB;
    private Boolean inside;
    private int time;
    private Map<String, Object> payload;

}
