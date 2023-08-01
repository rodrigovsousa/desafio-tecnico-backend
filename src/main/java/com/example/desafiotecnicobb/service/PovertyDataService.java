package com.example.desafiotecnicobb.service;

import com.example.desafiotecnicobb.client.PovertyDataClient;
import com.example.desafiotecnicobb.response.CountryDTO;
import com.example.desafiotecnicobb.response.DataDTO;
import com.example.desafiotecnicobb.response.IndicatorDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PovertyDataService {

    private final PovertyDataClient povertyDataClient;

    public PovertyDataService(PovertyDataClient povertyDataClient) {
        this.povertyDataClient = povertyDataClient;
    }

    public List<DataDTO> getDataPoverty(String countryId) {
        Object[] data = povertyDataClient.getPovertyData(countryId);
        List<DataDTO> dataDTOs = new ArrayList<>();

        if (data.length > 1 && data[1] instanceof List) {
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) data[1];
            for (Map<String, Object> item : dataList) {
                var indicatorMap = (Map<String, Object>) item.get("indicator");
                var countryMap = (Map<String, Object>) item.get("country");

                var indicator = new IndicatorDTO((String) indicatorMap.get("id"), (String) indicatorMap.get("value"));
                var country = new CountryDTO((String) countryMap.get("id"), (String) countryMap.get("value"));
                var date = (String) item.get("date");

                dataDTOs.add(new DataDTO(indicator, country, date));
            }
        }
        return dataDTOs;
    }

//    public Page<List<DataDTO>> getDataPoverty(String countryId, int pageNumber, int pageSize) {
//        Object[] data = povertyDataClient.getPovertyData(countryId);
//        List<DataDTO> dataDTOs = new ArrayList<>();
//
//        if (data.length > 1 && data[1] instanceof List) {
//            List<Map<String, Object>> dataList = (List<Map<String, Object>>) data[1];
//            for (Map<String, Object> item : dataList) {
//                var indicatorMap = (Map<String, Object>) item.get("indicator");
//                var countryMap = (Map<String, Object>) item.get("country");
//
//                var indicator = new IndicatorDTO((String) indicatorMap.get("id"), (String) indicatorMap.get("value"));
//                var country = new CountryDTO((String) countryMap.get("id"), (String) countryMap.get("value"));
//                var date = (String) item.get("date");
//
//                dataDTOs.add(new DataDTO(indicator, country, date));
//            }
//        }
//
//        int totalRecords = 1;
//
//        int startIndex = pageNumber * pageSize;
//        int endIndex = Math.min(startIndex + pageSize, dataDTOs.size());
//
//        List<DataDTO> currentPageData = dataDTOs.subList(startIndex, endIndex);
//
//        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
//        Page<List<DataDTO>> page = new PageImpl<>(Collections.singletonList(currentPageData), pageRequest, totalRecords);
//
//        return page;
//    }
}
