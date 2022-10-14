package com.nttdata.bootcamp.project.product.dto;

import com.nttdata.bootcamp.project.product.entity.AbstractAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveAccountDto /*extends AbstractAccount*/{
    private String id;
    private String product;
    private String description;
    private /*Date*/String creationDate;
}
