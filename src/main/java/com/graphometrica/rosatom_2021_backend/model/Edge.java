package com.graphometrica.rosatom_2021_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Edge {
    Integer src;
    Integer dst;
    Float weight;
}
