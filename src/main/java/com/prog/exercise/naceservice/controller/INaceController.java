package com.prog.exercise.naceservice.controller;

import com.prog.exercise.naceservice.dto.NaceDetailsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public interface INaceController {

    public ResponseEntity<NaceDetailsDto> putNaceDetails(@Validated @RequestBody final NaceDetailsDto naceDetails);

    public ResponseEntity<NaceDetailsDto> getNaceDetails(@PathVariable("orderId") Long orderId);
}
