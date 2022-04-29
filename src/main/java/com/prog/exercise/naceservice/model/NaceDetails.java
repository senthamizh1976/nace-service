package com.prog.exercise.naceservice.model;

import com.prog.exercise.naceservice.dto.NaceDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class NaceDetails extends AuditModel {

    @Id
    @EqualsAndHashCode.Include
    private Long orderId;

    @Column
    @EqualsAndHashCode.Include
    private int naceLevel;

    @Column
    private String code;

    @Column
    private String parent;

    @Column
    private String description;

    @Column
    private String itemIncludes;

    @Column
    private String itemAlsoIncludes;

    @Column
    private String rulings;

    @Column
    private String itemExcludes;

    @Column
    private String refToIsic;

    public NaceDetailsDto toDto() {
        return NaceDetailsDto.builder()
                .order(this.orderId)
                .level(this.naceLevel)
                .code(this.code)
                .parent(this.parent)
                .description(this.description)
                .itemIncludes(this.itemIncludes)
                .itemAlsoIncludes(this.itemAlsoIncludes)
                .rulings(this.rulings)
                .itemExcludes(this.itemExcludes)
                .refToIsic(this.refToIsic)
                .build();
    }

    public static NaceDetails fromDto(final NaceDetailsDto naceDetailsDto) {
        return NaceDetails.builder()
                .orderId(naceDetailsDto.getOrder())
                .naceLevel(naceDetailsDto.getLevel())
                .code(naceDetailsDto.getCode())
                .parent(naceDetailsDto.getParent())
                .description(naceDetailsDto.getDescription())
                .itemIncludes(naceDetailsDto.getItemIncludes())
                .itemAlsoIncludes(naceDetailsDto.getItemAlsoIncludes())
                .rulings(naceDetailsDto.getRulings())
                .itemExcludes(naceDetailsDto.getItemExcludes())
                .refToIsic(naceDetailsDto.getRefToIsic())
                .build();
    }
}

