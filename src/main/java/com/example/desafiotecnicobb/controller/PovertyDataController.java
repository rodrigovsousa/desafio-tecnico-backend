package com.example.desafiotecnicobb.controller;

import com.example.desafiotecnicobb.domain.DataDTO;
import com.example.desafiotecnicobb.service.PovertyDataService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/poverty-indicator")
public class PovertyDataController {

    private final PovertyDataService povertyDataService;

    public PovertyDataController(PovertyDataService povertyDataService) {
        this.povertyDataService = povertyDataService;
    }

    @Operation(summary = "Get all poverty indicators by country id", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Returns a list of poverty indicators by country id"),
        @ApiResponse(code = 404, message = "Country id not found")
    })
    @GetMapping("{countryId}")
    public List<DataDTO> getAllPovertyIndicators(@PathVariable("countryId") String countryId){
        return povertyDataService.getDataPoverty(countryId);
    }
}
