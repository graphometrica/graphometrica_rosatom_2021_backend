package com.graphometrica.rosatom_2021_backend.repository;

import com.graphometrica.rosatom_2021_backend.model.MetroConnection;
import org.springframework.data.repository.CrudRepository;

public interface ConnectionRepository extends CrudRepository<MetroConnection, String> {
}
