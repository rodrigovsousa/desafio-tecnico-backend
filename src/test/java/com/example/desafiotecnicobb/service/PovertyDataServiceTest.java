package com.example.desafiotecnicobb.service;

import com.example.desafiotecnicobb.client.PovertyDataClient;
import com.example.desafiotecnicobb.response.DataDTO;
import com.example.desafiotecnicobb.utils.PovertyDataCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PovertyDataServiceTest {
    @InjectMocks
    PovertyDataService service;

    @Mock
    private PovertyDataClient povertyDataClient;


    @Test
    void testGetDataPoverty_ValidCountryId_ReturnsExpectedDataDTO() {
        String countryId = "BR";
        Object[] validData = PovertyDataCreator.createValidDataAsArray();
        when(povertyDataClient.getPovertyData(countryId)).thenReturn(validData);
        service = new PovertyDataService(povertyDataClient);
        DataDTO expectedDataDTO = PovertyDataCreator.createValidData();

        List<DataDTO> result = service.getDataPoverty(countryId);

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
    void testGetDataPoverty_ValidCountryId_ReturnsDataDTOs() {
        String countryId = "BR";
        Object[] validData = new DataDTO[]{PovertyDataCreator.createValidData()};
        when(povertyDataClient.getPovertyData(countryId)).thenReturn(validData);
        service = new PovertyDataService(povertyDataClient);

        List<DataDTO> result = service.getDataPoverty(countryId);

        assertNotNull(result);
    }

    @Test
    void testGetDataPoverty_InvalidCountryId_ReturnsEmptyList() {
        String countryId = "AA";
        Object[] invalidData = new Object[] { 1, "This is not a list of indicators." };
        when(povertyDataClient.getPovertyData(countryId)).thenReturn(invalidData);
        service = new PovertyDataService(povertyDataClient);

        List<DataDTO> result = service.getDataPoverty(countryId);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetDataPoverty_NonExistentCountryId_ReturnsEmptyList() {
        String nonExistentCountryId = "999";
        Object[] emptyData = new Object[] { 0, new ArrayList<Map<String, Object>>() };
        when(povertyDataClient.getPovertyData(nonExistentCountryId)).thenReturn(emptyData);
        PovertyDataService service = new PovertyDataService(povertyDataClient);

        List<DataDTO> result = service.getDataPoverty(nonExistentCountryId);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

}
