package com.graphometrica.rosatom_2021_backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphometrica.rosatom_2021_backend.model.TspInput;
import com.graphometrica.rosatom_2021_backend.model.TspResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

class GraphometricaRosatom2021BackendApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        List<Double> floatList = List.of(1.,2.,3.);
        TspResult tspResult = new TspResult(
                List.of(1,2,3),
                1.,
                2.,
                "3",
                "solverType",
                "solutionType",
                List.of(floatList, floatList),
                List.of(floatList, floatList)
        );

        List<Integer> path;
        Float ham_energy;
        Float energy;

        String solverType;
        String solutionType;
        List<List<Float>> adj;
        List<List<Float>> qubo;

        ObjectMapper mapper = new ObjectMapper();
        String strResult = mapper.writeValueAsString(tspResult);
    }

    @Test
    void contextLoads2() throws JsonProcessingException {
        TspInput input = new TspInput();
        ObjectMapper mapper = new ObjectMapper();
        String strResult = mapper.writeValueAsString(input);
    }


    @Test
    void contextLoads3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var strResult = mapper.readValue("{\"some_string\":\"value\"}", dto.class);
        assert strResult.someString.equals("value");
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class dto {
        private String someString;
    }

}
