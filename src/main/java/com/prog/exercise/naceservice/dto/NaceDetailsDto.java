package com.prog.exercise.naceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NaceDetailsDto {

    @NotNull
    private Long order;

    private int level;

    private String code;

    private String parent;

    private String description;

    private String itemIncludes;

    private String itemAlsoIncludes;

    private String rulings;

    private String itemExcludes;

    private String refToIsic;
}
