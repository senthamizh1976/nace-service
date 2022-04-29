package com.prog.exercise.naceservice.controller;

import com.prog.exercise.naceservice.dto.NaceDetailsDto;
import com.prog.exercise.naceservice.model.NaceDetails;
import com.prog.exercise.naceservice.service.NaceService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class NaceController implements INaceController {

    Logger logger = LoggerFactory.getLogger(NaceController.class);

    @Autowired
    private NaceService naceService;

    @PostMapping(path = "/nace-details")
    public ResponseEntity<NaceDetailsDto> putNaceDetails(
            @Validated @RequestBody final NaceDetailsDto naceDetails) {
        logger.debug("putNaceDetails-Start");

        NaceDetails nace = naceService.putNaceDetails(naceDetails);

        logger.debug("putNaceDetails-End");
        return ResponseEntity.ok(nace.toDto());
    }

    @GetMapping("/nace-details/{orderId}")
    public ResponseEntity<NaceDetailsDto> getNaceDetails(@PathVariable("orderId") Long orderId) {
        logger.debug("getNaceDetails-Start");

        NaceDetails nace = naceService.getNaceDetails(orderId);

        logger.debug("getNaceDetails-End");
        return ResponseEntity.ok(nace.toDto());
    }
}
