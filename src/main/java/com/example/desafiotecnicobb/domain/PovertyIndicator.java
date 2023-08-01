package com.example.desafiotecnicobb.domain;

import lombok.*;

@Data
public class PovertyIndicator {
    private IndicatorDTO indicatorDTO;
    private CountryDTO countryDTO;
    private String countryiso3code;
    private String date;
    private Double value;
    private String unit;
    private String obs_status;
    private int decimal;
}
