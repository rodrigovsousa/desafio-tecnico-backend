package com.example.desafiotecnicobb.utils;

import com.example.desafiotecnicobb.domain.CountryDTO;
import com.example.desafiotecnicobb.domain.DataDTO;
import com.example.desafiotecnicobb.domain.IndicatorDTO;

import java.util.List;
import java.util.Map;

public class PovertyDataCreator {
    public static DataDTO createValidData() {
        return DataDTO.builder()
            .indicator(
                IndicatorDTO.builder()
                    .id("SI.POV.DDAY")
                    .value("Poverty headcount ratio at $2.15 a day (2017 PPP) (% of population)")
                    .build()
            )
            .country(
                CountryDTO.builder()
                    .id("BR")
                    .value("Brazil")
                    .build()
            )
            .date("2020")
            .build();
    }

    public static Object[] createValidDataAsArray() {
        return new Object[]{
            1,
            List.of(
                Map.of(
                    "indicator", Map.of("id", "SI.POV.DDAY",
                        "value", "Poverty headcount ratio at $2.15 a day (2017 PPP) (% of population)"),
                    "country", Map.of("id", "BR",
                        "value", "Brazil"),
                    "date", "2020"
                )
            )
        };
    }


}
