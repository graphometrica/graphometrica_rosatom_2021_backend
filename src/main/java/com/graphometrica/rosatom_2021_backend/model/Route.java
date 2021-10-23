package com.graphometrica.rosatom_2021_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeId;
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
