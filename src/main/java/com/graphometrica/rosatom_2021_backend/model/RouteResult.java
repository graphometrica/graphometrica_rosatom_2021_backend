package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;

import java.util.List;

@Data
public class RouteResult {

    private List<String> route;
    private Integer totalTime;
    private String routeCsv;
    private String quboMatrixCsv;
    private String adjacencyMatrixCsv;
    private String solutionType;
    private Double ham_energy;
    private String solverType;

}
