package com.graphometrica.rosatom_2021_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TspInput {

    @JsonProperty("edge_list")
    List<Edge> edgeList;
    @JsonProperty("solver_type")
    String solverType = "remote:simcim";
    @JsonProperty("router_id")
    String routerId;
}
