package com.prog.exercise.naceservice.controller;

import com.prog.exercise.naceservice.dto.NaceDetailsDto;
import com.prog.exercise.naceservice.model.NaceDetails;
import com.prog.exercise.naceservice.repository.NacedetailsDao;
import com.prog.exercise.naceservice.service.NaceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NaceControllerTest {

    private NaceService naceService = Mockito.mock(NaceService.class);

    @InjectMocks
    private NaceController naceController;

    @Order(1)
    @Test
    void putNaceDetailsControllerTest() {
        NaceDetailsDto naceDetailsDto = new NaceDetailsDto(111113L, 1, "A", "", "AGRICULTURE, FORESTRY AND FISHING",
                "This section includes the exploitation of vegetal and animal natural resources",
                "", "", "", "A");
        when(naceService.putNaceDetails(any(NaceDetailsDto.class))).thenReturn(new NaceDetails());
        ResponseEntity<NaceDetailsDto> responseEntity = naceController.putNaceDetails(naceDetailsDto);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
    }

    @Order(2)
    @Test
    void getNaceDetailsControllerTest() {
        when(naceService.getNaceDetails(111113L)).thenReturn(new NaceDetails());
        ResponseEntity<NaceDetailsDto> responseEntity = naceController.getNaceDetails(111113L);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
    }
}