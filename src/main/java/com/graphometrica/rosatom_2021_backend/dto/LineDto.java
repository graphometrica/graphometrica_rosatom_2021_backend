package com.graphometrica.rosatom_2021_backend.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphometrica.rosatom_2021_backend.model.Line;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Data
@NoArgsConstructor
public class LineDto {

    private String id;
    private String name;
    private Boolean isCircle;
    private Boolean isMCC;
    private String color;
    private Object payload;

    @SneakyThrows
    public LineDto(Line lineModel) {
        id = lineModel.getId();
        name = lineModel.getName();
        isCircle = lineModel.getIsCircle();
        isMCC = lineModel.getIsMCC();
        color = lineModel.getColor();
        ObjectMapper mapper = new ObjectMapper();
        payload = mapper.readTree(lineModel.getPayload());
    }

    @SneakyThrows
    public Line getModel() {
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
