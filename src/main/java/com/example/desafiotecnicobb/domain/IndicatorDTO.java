package com.example.desafiotecnicobb.domain;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndicatorDTO implements Serializable {
    private String id;
    private String value;
}


