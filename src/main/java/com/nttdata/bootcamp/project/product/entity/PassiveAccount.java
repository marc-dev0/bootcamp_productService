package com.nttdata.bootcamp.project.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Document(collection = "passiveAccount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassiveAccount /*extends AbstractAccount */{
    @Id
    private String id;
    private String product;
    private String description;
    private String creationDate;
    private Double commission;
    private Integer movementLimit;
}
