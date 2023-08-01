package com.example.desafiotecnicobb.domain;

import com.example.desafiotecnicobb.response.PovertyDataResponse;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        String country = "AFG";
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.worldbank.org/v2/country/%s/indicator/SI.POV.DDAY?format=json";
        PovertyDataResponse response = restTemplate.getForObject(String.format(url, country), PovertyDataResponse.class);
//        PovertyDataResponse povertyDataResponse = new PovertyDataResponse();
//        povertyDataResponse.setPagination((PaginationData) response[0]);
//        povertyDataResponse.setIndicator((List<PovertyIndicator>) response[1]);
        System.out.println(response);
    }
}
