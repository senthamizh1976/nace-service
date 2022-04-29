package com.prog.exercise.naceservice;

import com.prog.exercise.naceservice.controller.NaceController;
import com.prog.exercise.naceservice.dto.NaceDetailsDto;
import com.prog.exercise.naceservice.exception.InvalidOrderIdException;
import com.prog.exercise.naceservice.exception.InvalidRequestException;
import com.prog.exercise.naceservice.exception.NoOrderDetailsFoundException;
import com.prog.exercise.naceservice.model.NaceDetails;
import com.prog.exercise.naceservice.service.NaceService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NaceServiceIntegrationTests {

    @Autowired
    private NaceService naceService;

    @Autowired
    private NaceController naceController;

    @Test
    void contextLoads() {
    }

    @Test
    void invalidRequestExceptionTest() {
        assertThrows(InvalidRequestException.class,
                () -> {
                    naceService.putNaceDetails(null);
                });
    }

    @Test
    void invalidDataRequestExceptionTest() {
        assertThrows(InvalidRequestException.class,
                () -> {
                    NaceDetailsDto naceDetailsDto = new NaceDetailsDto(0L, 1, "A", "", "AGRICULTURE, FORESTRY AND FISHING",
                            "This section includes the exploitation of vegetal and animal natural resources",
                            "", "", "", "A");
                    naceService.putNaceDetails(naceDetailsDto);
                });
    }

    @Test
    void invalidOrderIdExceptionTest() {
        assertThrows(InvalidOrderIdException.class,
                () -> {
                    naceService.getNaceDetails(0L);
                });
    }

    @Test
    void noOrderDetailsFoundExceptionTest() {
        assertThrows(NoOrderDetailsFoundException.class,
                () -> {
                    naceService.getNaceDetails(99999L);
                });
    }

    @Order(1)
    @Test
    void putNaceDetails() {
        NaceDetailsDto naceDetailsDto = new NaceDetailsDto(111111L, 1, "A", "", "AGRICULTURE, FORESTRY AND FISHING",
                "This section includes the exploitation of vegetal and animal natural resources",
                "", "", "", "A");
        NaceDetails naceDetails = naceService.putNaceDetails(naceDetailsDto);
        assertEquals(naceDetails.getCode(), naceDetailsDto.getCode());
    }

    @Order(2)
    @Test
    void putNaceDetailsControllerTest() {
        NaceDetailsDto naceDetailsDto = new NaceDetailsDto(111112L, 1, "A", "", "AGRICULTURE, FORESTRY AND FISHING",
                "This section includes the exploitation of vegetal and animal natural resources",
                "", "", "", "A");
        ResponseEntity<NaceDetailsDto> responseEntity = naceController.putNaceDetails(naceDetailsDto);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
    }

    @Order(3)
    @Test
    void getNaceDetails() {
        NaceDetails naceDetails = naceService.getNaceDetails(111111L);
        assertEquals(naceDetails.getCode(), "A");
    }

    @Order(4)
    @Test
    void getNaceDetailsControllerTest() {
        ResponseEntity<NaceDetailsDto> responseEntity = naceController.getNaceDetails(111112L);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
    }
}
