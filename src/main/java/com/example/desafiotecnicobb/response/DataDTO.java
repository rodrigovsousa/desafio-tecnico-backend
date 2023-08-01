package com.example.desafiotecnicobb.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataDTO {
    private IndicatorDTO indicator;
    private CountryDTO country;
    private String date;
}
