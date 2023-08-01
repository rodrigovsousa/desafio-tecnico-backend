package com.example.desafiotecnicobb.response;

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


