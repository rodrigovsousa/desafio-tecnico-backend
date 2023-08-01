package com.example.desafiotecnicobb.integration;

import com.example.desafiotecnicobb.controller.PovertyDataController;
import com.example.desafiotecnicobb.response.DataDTO;
import com.example.desafiotecnicobb.service.PovertyDataService;
import com.example.desafiotecnicobb.utils.PovertyDataCreator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PovertyDataControllerIntegrationTest {

    @Autowired
    private PovertyDataController povertyDataController;

    @MockBean
    private PovertyDataService povertyDataService;

    @Test
    public void testGetAllPovertyIndicators_ValidCountryId() {
        String countryId = "BR";
        Object[] validData = PovertyDataCreator.createValidDataAsArray();
        when(povertyDataService.getDataPoverty(countryId)).thenReturn(List.of(PovertyDataCreator.createValidData()));
        povertyDataService = new PovertyDataService(data -> validData);
        DataDTO expectedDataDTO = PovertyDataCreator.createValidData();

        List<DataDTO> result = povertyDataService.getDataPoverty(countryId);

        assertNotNull(result);
        assertEquals(1, result.size());
        DataDTO actualDataDTO = result.get(0);
        assertEquals(expectedDataDTO.getIndicator().getId(), actualDataDTO.getIndicator().getId());
        assertEquals(expectedDataDTO.getIndicator().getValue(), actualDataDTO.getIndicator().getValue());
        assertEquals(expectedDataDTO.getCountry().getId(), actualDataDTO.getCountry().getId());
        assertEquals(expectedDataDTO.getCountry().getValue(), actualDataDTO.getCountry().getValue());
        assertEquals(expectedDataDTO.getDate(), actualDataDTO.getDate());
    }

    @Test
    public void testGetAllPovertyIndicators_NullCountryId() {
        List<DataDTO> result = povertyDataController.getAllPovertyIndicators(null);
        assertEquals(0, result.size());
    }

    @Test
    public void testGetAllPovertyIndicators_InvalidCountryId() {
        String invalidCountryId = "INVALID";

        when(povertyDataService.getDataPoverty(invalidCountryId)).thenReturn(Collections.emptyList());

        List<DataDTO> result = povertyDataController.getAllPovertyIndicators(invalidCountryId);

        assertEquals(0, result.size());
    }
}
