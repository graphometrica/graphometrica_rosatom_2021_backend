package com.graphometrica.rosatom_2021_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphometrica.rosatom_2021_backend.model.Route;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
public class RouteDto {

    private Integer routeId;
    private List<String> stations;
    private Integer status;
    private Object payload;
    private Long created;
    private Long calculated;
    private Map<String, Object> result;
    /*
    private List<String> route;
    private Integer totalTime;
    private String routeCsv;
    private String quboMatrixCsv;
    private String adjacencyMatrixCsv;
    private String solutionType;
    private Double hamEnergy;
    private String solverType;
     */

    @SneakyThrows
    public RouteDto(Route model) {
        var mapper = new ObjectMapper();
        routeId = model.getRouteId();
        if (model.getCreated() != null) {
            created = model.getCreated().getTime();
        }
        if (model.getCalculated() != null) {
            calculated = model.getCalculated().getTime();
        }
        if(model.getStations() != null) {
            stations = mapper.readValue(model.getStations(), new TypeReference<>() {
            });
        }
        status = model.getStatus();
        if(model.getPayload() != null) {
            payload = mapper.readTree(model.getPayload());
        }
        result = new HashMap<>();
        if(model.getRoute() != null) {
            result.put("route", mapper.readValue(model.getRoute(), new TypeReference<>() {}));
        }
        result.put("totalTime", model.getTotalTime());
        result.put("routeCsv", model.getRouteCsv());
        result.put("quboMatrixCsv", model.getQuboMatrixCsv());
        result.put("adjacencyMatrixCsv", model.getAdjacencyMatrixCsv());
        result.put("solutionType", model.getSolutionType());
        result.put("hamEnergy", model.getHamEnergy());
        result.put("solverType", model.getSolverType());
    }

    @SneakyThrows
    public Route toModel() {
        var route = new Route();
        route.setRouteId(routeId);

        ObjectMapper mapper = new ObjectMapper();

        route.setStations(mapper.writeValueAsString(stations));
        route.setStatus(status);
        route.setPayload(mapper.writeValueAsString(payload));
        if(created != null) {
            route.setCreated(new Date(created));
        }
        if(calculated != null) {
            route.setCalculated(new Date(calculated));
        }
        if(result != null) {
            route.setRoute(mapper.writeValueAsString(result.get("route")));
            route.setTotalTime(Integer.parseInt(String.valueOf(result.getOrDefault("totalTime", "0"))));
            route.setRouteCsv(String.valueOf(result.getOrDefault("routeCsv", "")));
            route.setQuboMatrixCsv(String.valueOf(result.getOrDefault("quboMatrixCsv", "")));
            route.setAdjacencyMatrixCsv(String.valueOf(result.getOrDefault("adjacencyMatrixCsv", "")));
            route.setSolutionType(String.valueOf(result.getOrDefault("solutionType", "")));
            route.setHamEnergy(Double.parseDouble(String.valueOf(result.getOrDefault("hamEnergy", "0"))));
            route.setSolverType(String.valueOf(result.getOrDefault("solverType", "")));
        }
        return route;

    }

}
