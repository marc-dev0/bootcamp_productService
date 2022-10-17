package com.nttdata.bootcamp.project.product.dto;

import com.nttdata.bootcamp.project.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassiveAccountDto {
    private String id;
    @DBRef
    private Product product;
    private String description;
    private String creationDate;
    private Double commission;
    private Integer movementLimit;
}
