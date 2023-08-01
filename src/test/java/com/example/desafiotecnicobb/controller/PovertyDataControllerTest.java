package com.example.desafiotecnicobb.controller;

import com.example.desafiotecnicobb.domain.DataDTO;
import com.example.desafiotecnicobb.service.PovertyDataService;
import com.example.desafiotecnicobb.utils.PovertyDataCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PovertyDataControllerTest {

    @Mock
    private PovertyDataService povertyDataService;

    @InjectMocks
    private PovertyDataController povertyDataController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

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
