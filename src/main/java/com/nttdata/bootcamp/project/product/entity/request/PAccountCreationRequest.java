package com.nttdata.bootcamp.project.product.entity.request;

import lombok.Data;

@Data

public class PAccountCreationRequest {
    private String productoId;
    private String description;
    private String creationDate;
    private Double commission;
    private Integer movementLimit;
}
