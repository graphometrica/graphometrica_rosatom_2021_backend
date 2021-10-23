package com.graphometrica.rosatom_2021_backend.controller;

import com.graphometrica.rosatom_2021_backend.dto.LineDto;
import com.graphometrica.rosatom_2021_backend.dto.RouteDto;
import com.graphometrica.rosatom_2021_backend.dto.StationDto;
import com.graphometrica.rosatom_2021_backend.model.MetroConnection;
import com.graphometrica.rosatom_2021_backend.model.Line;
import com.graphometrica.rosatom_2021_backend.model.Route;
import com.graphometrica.rosatom_2021_backend.model.Station;
import com.graphometrica.rosatom_2021_backend.service.FrontService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class FrontendController {

    private final FrontService frontService;

    @GetMapping("/getLines")
    public Iterable<LineDto> getLines() {
        return StreamSupport.stream(frontService.getAllLines().spliterator(), false)
                .map(LineDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/getStations")
    public Iterable<StationDto> getStations() {
        return StreamSupport.stream(frontService.getAllStations().spliterator(), false)
                .map(StationDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/getConnections")
    public Iterable<MetroConnection> getConnections() {
        return frontService.getAllConnections();
    }

    @GetMapping("/getRoutes")
    public Iterable<RouteDto> getRoutes() {
        return StreamSupport.stream(frontService.getAllRoutes().spliterator(), false)
                .map(RouteDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/createRoute")
    public RouteDto createRoute(@RequestBody RouteDto route) {
        return new RouteDto(frontService.createRoute(route.toModel()));
    }

    @PostMapping("/sendForCalculate/{id}")
    public void sendForCalculate(@PathVariable("id") int routeId) {
        frontService.sendToCalculate(routeId);
    }

}
