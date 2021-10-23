package com.graphometrica.rosatom_2021_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TspResult {
    List<Integer> path;
    @JsonProperty("ham_energy")
    Double hamEnergy;
    Double energy;

    @JsonProperty("router_id")
    String routerId;
    @JsonProperty("solver_type")
    String solverType = "remote:simcim";
    @JsonProperty("solution_type")
    String solutionType;
    List<List<Double>> adj;
    List<List<Double>> qubo;
}
