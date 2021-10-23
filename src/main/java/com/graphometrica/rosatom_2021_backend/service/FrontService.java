package com.graphometrica.rosatom_2021_backend.service;

import com.graphometrica.rosatom_2021_backend.model.Line;
import com.graphometrica.rosatom_2021_backend.model.Station;
import com.graphometrica.rosatom_2021_backend.repository.LineRepository;
import com.graphometrica.rosatom_2021_backend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FrontService {

    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public Iterable<Line> getAllLines() {
        return lineRepository.findAll();
    }

    public Iterable<Station> getAllStations() {
        return stationRepository.findAll();
    }

}
