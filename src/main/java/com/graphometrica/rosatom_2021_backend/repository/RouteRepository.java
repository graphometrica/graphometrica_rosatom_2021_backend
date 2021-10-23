package com.graphometrica.rosatom_2021_backend.repository;

import com.graphometrica.rosatom_2021_backend.model.Route;
import com.graphometrica.rosatom_2021_backend.model.Station;
import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends CrudRepository<Route, String> {
}
