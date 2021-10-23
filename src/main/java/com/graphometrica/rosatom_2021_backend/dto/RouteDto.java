package com.graphometrica.rosatom_2021_backend.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphometrica.rosatom_2021_backend.model.Route;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class RouteDto {

    private String routeId;
    private List<String> stations;
    private Integer status;
    private Object payload;
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
    public RouteDto(Route routeModel) {
        var mapper = new ObjectMapper();
        routeId = routeModel.getRouteId();
        stations = mapper.readValue(routeModel.getStations(), new TypeReference<>() {});
        status = routeModel.getStatus();
        payload = mapper.readTree(routeModel.getPayload());
        result = new HashMap<>();
        result.put("route", mapper.readValue(routeModel.getRoute(), new TypeReference<>() {}));
        result.put("totalTime", routeModel.getTotalTime());
        result.put("routeCsv", routeModel.getRouteCsv());
        result.put("quboMatrixCsv", routeModel.getQuboMatrixCsv());
        result.put("adjacencyMatrixCsv", routeModel.getAdjacencyMatrixCsv());
        result.put("solutionType", routeModel.getSolutionType());
        result.put("hamEnergy", routeModel.getHamEnergy());
        result.put("solverType", routeModel.getSolverType());
    }

    @SneakyThrows
    public Route getModel() {
        var route = new Route();
        route.setRouteId(routeId);

        ObjectMapper mapper = new ObjectMapper();

        route.setStations(mapper.writeValueAsString(stations));
        route.setStatus(status);
        route.setPayload(mapper.writeValueAsString(payload));
        route.setRoute(mapper.writeValueAsString(result.get("route")));
        route.setTotalTime(Integer.parseInt(String.valueOf(result.getOrDefault("totalTime", "0"))));
        route.setRouteCsv(String.valueOf(result.getOrDefault("routeCsv", "")));
        route.setQuboMatrixCsv(String.valueOf(result.getOrDefault("quboMatrixCsv", "")));
        route.setAdjacencyMatrixCsv(String.valueOf(result.getOrDefault("adjacencyMatrixCsv", "")));
        route.setSolutionType(String.valueOf(result.getOrDefault("solutionType", "")));
        route.setHamEnergy(Double.parseDouble(String.valueOf(result.getOrDefault("hamEnergy", "0"))));
        route.setSolverType(String.valueOf(result.getOrDefault("solverType", "")));

        return route;

    }

}
