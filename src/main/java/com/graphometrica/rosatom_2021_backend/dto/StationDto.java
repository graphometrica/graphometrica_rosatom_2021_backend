package com.graphometrica.rosatom_2021_backend.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphometrica.rosatom_2021_backend.model.Station;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Data
@NoArgsConstructor
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
    public StationDto(Station stationModel) {
        id = stationModel.getId();
        stationId = stationModel.getStationId();
        name = stationModel.getName();
        inCircle = stationModel.getInCircle();
        top = stationModel.getTop();
        left = stationModel.getLeft();
        labelTop = stationModel.getLabelTop();
        labelLeft = stationModel.getLabelLeft();
        labelRight = stationModel.getLabelRight();
        labelBottom = stationModel.getLabelBottom();
        close = stationModel.getClose();
        outside = stationModel.getOutside();

        ObjectMapper objectMapper = new ObjectMapper();
        payload = objectMapper.readTree(stationModel.getPayload());
    }

    @SneakyThrows
    public Station getModel() {
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
