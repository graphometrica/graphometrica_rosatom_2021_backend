package com.graphometrica.rosatom_2021_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.graphometrica.rosatom_2021_backend.model.Line;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Optional;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
public class LineDto {

    private String id;
    private String name;
    private Boolean isCircle;
    private Boolean isMCC;
    private String color;
    private Object payload;

    @SneakyThrows
    public LineDto(Line model) {
        id = model.getId();
        name = model.getName();
        isCircle = model.getIsCircle();
        isMCC = model.getIsMCC();
        color = model.getColor();
        ObjectMapper mapper = new ObjectMapper();
        if(model.getPayload() != null) {
            payload = mapper.readTree(model.getPayload());
        }
    }

    @SneakyThrows
    public Line toModel() {
        var line = new Line();
        line.setId(id);
        line.setName(name);
        line.setIsCircle(isCircle);
        line.setIsMCC(isMCC);
        line.setColor(color);

        ObjectMapper mapper = new ObjectMapper();

        line.setPayload(mapper.writeValueAsString(payload));

        return line;

    }

}
