package com.prog.exercise.naceservice.service;

import com.prog.exercise.naceservice.dto.NaceDetailsDto;
import com.prog.exercise.naceservice.model.NaceDetails;
import com.prog.exercise.naceservice.repository.NacedetailsDao;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NaceServiceTest {

    private NacedetailsDao nacedetailsDao = Mockito.mock(NacedetailsDao.class);

    @InjectMocks
    private NaceService naceService;

    @Order(1)
    @Test
    void putNaceDetailsControllerTest() {
        NaceDetailsDto naceDetailsDto = new NaceDetailsDto(111113L, 1, "A", "", "AGRICULTURE, FORESTRY AND FISHING",
                "This section includes the exploitation of vegetal and animal natural resources",
                "", "", "", "A");
        NaceDetails naceDetails = new NaceDetails(111113L, 1, "A", "", "AGRICULTURE, FORESTRY AND FISHING",
                "This section includes the exploitation of vegetal and animal natural resources",
                "", "", "", "A");
        when(nacedetailsDao.save(any(NaceDetails.class))).thenReturn(naceDetails);
        naceDetails = naceService.putNaceDetails(naceDetailsDto);
        assertEquals(naceDetails.getCode(), naceDetailsDto.getCode());
    }

    @Order(2)
    @Test
    void getNaceDetailsControllerTest() {
        when(nacedetailsDao.findByOrderId(111113L)).thenReturn(new NaceDetails());
        NaceDetails naceDetails = naceService.getNaceDetails(111113L);
        assertEquals(naceDetails.getCode(), naceDetails.getCode());
    }
}