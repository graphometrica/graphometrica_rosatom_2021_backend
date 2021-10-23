package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.List;
import java.util.Map;

@Data
public class Route {

    private String routeId;
    @Transient
    private List<String> stations;
    private Integer status;
    @Transient
    private Map<String, Object> payload;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private RouteResult result;

}
