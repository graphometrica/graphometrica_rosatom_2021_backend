package com.graphometrica.rosatom_2021_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphometrica.rosatom_2021_backend.model.Station;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.NON_NULL)
public class StationDto {

    private int id;
    private String stationId;
    private String name;
    private Boolean inCircle;
    private Integer top;
    private Integer left;
    private Integer labelTop;
    private Integer labelLeft;
    private Integer labelRight;
    private Integer labelBottom;
    private Boolean close;
    private Boolean outside;
    private Object payload;

    @SneakyThrows
    public StationDto(Station model) {
        id = model.getId();
        stationId = model.getStationId();
        name = model.getName();
        inCircle = model.getInCircle();
        top = model.getTop();
        left = model.getLeft();
        labelTop = model.getLabelTop();
        labelLeft = model.getLabelLeft();
        labelRight = model.getLabelRight();
        labelBottom = model.getLabelBottom();
        close = model.getClose();
        outside = model.getOutside();

        ObjectMapper mapper = new ObjectMapper();
        if(model.getPayload() != null) {
            payload = mapper.readTree(model.getPayload());
        }
    }

    @SneakyThrows
    public Station toModel() {
        var station = new Station();
        station.setStationId(stationId);
        station.setId(id);
        station.setName(name);
        station.setInCircle(inCircle);
        station.setTop(top);
        station.setLeft(left);
        station.setLabelTop(labelTop);
        station.setLabelRight(labelRight);
        station.setLabelBottom(labelBottom);
        station.setClose(close);
        station.setOutside(outside);

        ObjectMapper objectMapper = new ObjectMapper();
        station.setPayload(objectMapper.writeValueAsString(payload));

        return station;
    }

}
