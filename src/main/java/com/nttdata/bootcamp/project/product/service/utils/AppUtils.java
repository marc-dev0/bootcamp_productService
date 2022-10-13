package com.nttdata.bootcamp.project.product.service.utils;

import com.nttdata.bootcamp.project.product.dto.ProductDto;
import com.nttdata.bootcamp.project.product.entity.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static ProductDto entityToDto(Product product)
    {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntity(ProductDto customerDto)
    {
        Product product = new Product();
        BeanUtils.copyProperties(customerDto, product);
        return product;
    }
}
