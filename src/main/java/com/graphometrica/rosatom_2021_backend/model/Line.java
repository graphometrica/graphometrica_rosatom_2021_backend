package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.Map;

@Data
public class Line {

    @Id
    private String id;
    private String name;
    private Boolean isCircle;
    private Boolean isMCC;
    private String color;
    private String payload;

}
