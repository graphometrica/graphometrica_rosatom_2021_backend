package com.graphometrica.rosatom_2021_backend.service;

import com.graphometrica.rosatom_2021_backend.dto.RouteDto;
import com.graphometrica.rosatom_2021_backend.model.*;
import com.graphometrica.rosatom_2021_backend.repository.ConnectionRepository;
import com.graphometrica.rosatom_2021_backend.repository.LineRepository;
import com.graphometrica.rosatom_2021_backend.repository.RouteRepository;
import com.graphometrica.rosatom_2021_backend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FrontService {

    private final LineRepository lineRepository;
    private final StationRepository stationRepository;
    private final ConnectionRepository connectionRepository;
    private final RouteRepository routeRepository;
    private final GraphService graphService;
    private final TspJmsServiceInterface tspJmsService;


    public Iterable<Line> getAllLines() {
        return lineRepository.findAll();
    }

    public Iterable<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Iterable<MetroConnection> getAllConnections() {
        return connectionRepository.findAll();
    }

    public Iterable<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Route createRoute(Route route) {
        route.setStatus(1);
        route.setCreated(new Date());
        var result =  routeRepository.save(route);
        sendToCalculate(result.getRouteId());
        return result;
    }

    public void sendToCalculate(int routeId) {
        var input = routeRepository.findById(routeId)
                .map(RouteDto::new)
                .map(dto -> new TspInput(
                                graphService.generatePairs(dto.getStations()),
                                (String) dto.getResult().getOrDefault("solverType", "remote:simcim"),
                                String.valueOf(dto.getRouteId())
                        )
                )
                .orElseThrow(() -> new EntityNotFoundException("Router " + routeId + " not found"));

        tspJmsService.sendMessageTspSolver(input);
    }
}
