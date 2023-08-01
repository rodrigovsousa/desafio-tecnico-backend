package com.example.desafiotecnicobb.response;

import com.example.desafiotecnicobb.domain.PaginationData;
import com.example.desafiotecnicobb.domain.PovertyIndicator;
import lombok.Data;

@Data
public class PovertyDataResponse {
    private PaginationData pagination;
    private PovertyIndicator indicator;
}
