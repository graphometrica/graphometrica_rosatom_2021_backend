package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Route {

    private String routeId;
    private List<String> stations;
    private Integer status;
    private Map<String, Object> payload;
    private RouteResult result;

}
