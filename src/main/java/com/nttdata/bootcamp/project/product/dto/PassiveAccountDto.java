package com.nttdata.bootcamp.project.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassiveAccountDto {
    private String id;
    private String product;
    private String description;
    private String creationDate;
    private Double commission;
    private Integer movementLimit;
}
