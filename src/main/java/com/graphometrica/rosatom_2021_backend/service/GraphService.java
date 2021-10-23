package com.graphometrica.rosatom_2021_backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphometrica.rosatom_2021_backend.dto.RouteDto;
import com.graphometrica.rosatom_2021_backend.model.Edge;
import com.graphometrica.rosatom_2021_backend.model.Station;
import com.graphometrica.rosatom_2021_backend.model.TspResult;
import com.graphometrica.rosatom_2021_backend.repository.ConnectionRepository;
import com.graphometrica.rosatom_2021_backend.repository.RouteRepository;
import com.graphometrica.rosatom_2021_backend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.paukov.combinatorics3.Generator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GraphService {

    private final StationRepository stationRepository;
    private final ConnectionRepository connectionRepository;
    private final RouteRepository routeRepository;
    private Map<String, Station> stationsMap;
    private Map<Integer, Station> stationsIdMap;
    private SimpleWeightedGraph<Object, DefaultWeightedEdge>  metroGraph;

    @PostConstruct
    public void init() {
        metroGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        stationsMap = StreamSupport.stream(stationRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(Station::getStationId, s -> s));
        stationsIdMap = StreamSupport.stream(stationRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(Station::getId, s -> s));
        stationsMap.values().forEach(metroGraph::addVertex);
        connectionRepository.findAll().forEach(conn -> {
            var time = conn.getTime();
            var stationA = stationsMap.get(conn.getStationA());
            var stationB = stationsMap.get(conn.getStationB());
            var edge = metroGraph.addEdge(stationA, stationB);
            metroGraph.setEdgeWeight(edge, time);
        });
    }

    public List<Edge> generatePairs(List<String> stations) {

        return Generator.combination(stations)
                .simple(2)
                .stream()
                .map(a -> new Edge(
                        stationsMap.get(a.get(0)).getId(),
                        stationsMap.get(a.get(1)).getId(),
                        getShortestWeight(a.get(0), a.get(1))))
                .collect(Collectors.toList());
    }

    private double getShortestWeight(String stationA, String stationB) {
        var pathFinder = new DijkstraShortestPath<>(metroGraph);
        return pathFinder.getPath(stationsMap.get(stationA),stationsMap.get(stationB)).getWeight();
    }

    public void updateRouter(TspResult result) {
        ObjectMapper mapper = new ObjectMapper();
        routeRepository.findById(Integer.parseInt(result.getRouterId()))
                .ifPresent(router -> {
                    router.setStatus(3);
                    router.setRouteCsv(result.getPath().stream()
                            .map(stationsIdMap::get)
                            .map(Station::getStationId)
                            .collect(Collectors.joining(",")));
                    try {
                        router.setRoute(mapper.writeValueAsString(result.getPath().stream()
                                .map(stationsIdMap::get)
                                .map(Station::getStationId)
                                .collect(Collectors.toList())));
                        router.setAdjacencyMatrixCsv(mapper.writeValueAsString(result.getAdj()));
                        router.setQuboMatrixCsv(mapper.writeValueAsString(result.getQubo()));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    router.setSolverType(result.getSolverType());
                    router.setHamEnergy(result.getHamEnergy());
                    router.setSolutionType(result.getSolutionType());
                    router.setTotalTime(result.getEnergy().intValue());
                    router.setCalculated(new Date());
                    routeRepository.save(router);
                });
    }

}
