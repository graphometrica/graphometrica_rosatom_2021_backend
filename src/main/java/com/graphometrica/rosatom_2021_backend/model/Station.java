package com.graphometrica.rosatom_2021_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Station {

    @Id
    private int id;
    private String stationId;
    private String name;
    private String lineId;
    private Boolean inCircle;
    private Integer top;
    private Integer left;
    private Integer labelTop;
    private Integer labelLeft;
    private Integer labelRight;
    private Integer labelBottom;
    private Boolean close;
    private Boolean outside;
    private String payload;

}
