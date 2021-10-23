package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;

import java.util.Map;

@Data
public class Line {

    private String id;
    private String name;
    private boolean isCirce;
    private boolean isMCC;
    private String color;
    private Map<String, Object> payload;

}
