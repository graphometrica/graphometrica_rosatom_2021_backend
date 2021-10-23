package com.graphometrica.rosatom_2021_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TspResult {
    List<Integer> path;
    Float ham_energy;
    Float energy;

    String solverType;
    String solutionType;
    List<List<Float>> adj;
    List<List<Float>> qubo;
}
