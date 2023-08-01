package com.example.desafiotecnicobb.client;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "poverty-data-client", url = "https://api.worldbank.org/v2/country/")
public interface PovertyDataClient {

    @GetMapping("{countryId}/indicator/SI.POV.DDAY?format=json")
    @Headers("Accept: application/json")
    Object[] getPovertyData(@PathVariable("countryId") String countryId);
}
