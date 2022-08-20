package org.aibles.worker2.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * */
@Data
public class WorkerDto {
    @NotBlank
    @Size(min = 2, max = 128)
    private String name;

    private int date;
    private int years_of_work;

    @NotBlank
    @Size(min = 5, max = 200)
    private String address;

    private double wage;
    private double allowance;



}