package com.graphometrica.rosatom_2021_backend.controller;

import com.graphometrica.rosatom_2021_backend.model.Line;
import com.graphometrica.rosatom_2021_backend.model.Route;
import com.graphometrica.rosatom_2021_backend.model.Station;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class FrontendController {

    @GetMapping("/getLines")
    public List<Line> getLines() {
        return List.of();
    }

    @GetMapping("/getStations")
    public List<Station> getStations() {
        return List.of();
    }

    @GetMapping("/getRoutes")
    public List<Route> getRoutes() {
        return List.of();
    }

    @PostMapping("/createRoute")
    public Route createRoute(@RequestBody Route route) {
        return new Route();
    }

    @PostMapping("/processRoute/{id}")
    public void createRoute(@PathVariable("id") String routeId) {

    }

}
