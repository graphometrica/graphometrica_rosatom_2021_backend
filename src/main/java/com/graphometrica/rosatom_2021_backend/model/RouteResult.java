package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Data
public class RouteResult {

    @Transient
    private List<String> route;
    private Integer totalTime;
    private String routeCsv;
    private String quboMatrixCsv;
    private String adjacencyMatrixCsv;
    private String solutionType;
    private Double hamEnergy;
    private String solverType;

}
