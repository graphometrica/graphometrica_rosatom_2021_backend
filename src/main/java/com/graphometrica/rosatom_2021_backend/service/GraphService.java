package com.graphometrica.rosatom_2021_backend.service;

import com.graphometrica.rosatom_2021_backend.model.Edge;
import com.graphometrica.rosatom_2021_backend.model.Station;
import com.graphometrica.rosatom_2021_backend.model.TspResult;
import com.graphometrica.rosatom_2021_backend.repository.ConnectionRepository;
import com.graphometrica.rosatom_2021_backend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.paukov.combinatorics3.Generator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GraphService {

    private final StationRepository stationRepository;
    private final ConnectionRepository connectionRepository;
    private Map<String, Station> stationsMap;
    private SimpleWeightedGraph<Object, DefaultWeightedEdge>  metroGraph;

    @PostConstruct
    public void init() {
        metroGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        stationsMap = StreamSupport.stream(stationRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(Station::getStationId, s -> s));
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

    public void updateRouter(TspResult result, String routerId) {

    }

}
