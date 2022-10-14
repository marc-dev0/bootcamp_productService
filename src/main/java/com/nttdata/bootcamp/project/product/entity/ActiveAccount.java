package com.nttdata.bootcamp.project.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Document(collection = "activeAccount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TypeAlias("ActiveAccount")
public class ActiveAccount /*extends AbstractAccount*/{
    @Id
    private String id;
    private String product;
    private String description;
    private /*Date*/String creationDate;
}
