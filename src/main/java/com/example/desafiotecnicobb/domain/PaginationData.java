package com.example.desafiotecnicobb.domain;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginationData implements Serializable {
    private int page;
    private int pages;
    private int per_page;
    private int total;
    private String sourceid;
    private String lastupdated;
}
