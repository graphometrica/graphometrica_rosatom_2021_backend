package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Route {

    @Id
    private String routeId;
    private String stations;
    private Integer status;
    private String payload;
    private String route;
    private Integer totalTime;
    private String routeCsv;
    private String quboMatrixCsv;
    private String adjacencyMatrixCsv;
    private String solutionType;
    private Double hamEnergy;
    private String solverType;

}
