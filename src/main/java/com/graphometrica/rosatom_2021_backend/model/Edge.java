package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;

@Data
public class Edge {
    Integer src;
    Integer dst;
    Float weight;
}
