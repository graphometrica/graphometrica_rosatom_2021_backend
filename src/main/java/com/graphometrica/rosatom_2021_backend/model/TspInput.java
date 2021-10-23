package com.graphometrica.rosatom_2021_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TspInput {
    List<Edge> edgeList;
    String solverType;
    String routerId;
}
