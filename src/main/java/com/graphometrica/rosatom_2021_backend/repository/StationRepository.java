package com.graphometrica.rosatom_2021_backend.repository;

import com.graphometrica.rosatom_2021_backend.model.Line;
import com.graphometrica.rosatom_2021_backend.model.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, String> {
}
