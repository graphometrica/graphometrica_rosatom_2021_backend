package com.graphometrica.rosatom_2021_backend.service;

import com.graphometrica.rosatom_2021_backend.dto.RouteDto;
import com.graphometrica.rosatom_2021_backend.model.MetroConnection;
import com.graphometrica.rosatom_2021_backend.model.Line;
import com.graphometrica.rosatom_2021_backend.model.Route;
import com.graphometrica.rosatom_2021_backend.model.Station;
import com.graphometrica.rosatom_2021_backend.repository.ConnectionRepository;
import com.graphometrica.rosatom_2021_backend.repository.LineRepository;
import com.graphometrica.rosatom_2021_backend.repository.RouteRepository;
import com.graphometrica.rosatom_2021_backend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FrontService {

    private final LineRepository lineRepository;
    private final StationRepository stationRepository;
    private final ConnectionRepository connectionRepository;
    private final RouteRepository routeRepository;


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
        return routeRepository.save(route);
    }

    public void sendToCalculate(int route) {
        //Find all shortest ways between stations
        //send to MQ
    }
}
