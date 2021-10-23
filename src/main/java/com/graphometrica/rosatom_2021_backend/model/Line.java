package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.Map;

@Data
public class Line {

    private String id;
    private String name;
    private Boolean isCircle;
    private Boolean isMCC;
    private String color;
    @Transient
    private Map<String, Object> payload;

}
