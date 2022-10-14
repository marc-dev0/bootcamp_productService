package com.nttdata.bootcamp.project.product.service.utils;

import com.nttdata.bootcamp.project.product.dto.ActiveAccountDto;
import com.nttdata.bootcamp.project.product.dto.PassiveAccountDto;
import com.nttdata.bootcamp.project.product.dto.ProductDto;
import com.nttdata.bootcamp.project.product.entity.ActiveAccount;
import com.nttdata.bootcamp.project.product.entity.PassiveAccount;
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

    public static ActiveAccountDto entityToDto(ActiveAccount object)
    {
        ActiveAccountDto objectDto = new ActiveAccountDto();
        BeanUtils.copyProperties(object, objectDto);
        return objectDto;
    }

    public static ActiveAccount dtoToEntity(ActiveAccountDto objectDto)
    {
        ActiveAccount object = new ActiveAccount();
        BeanUtils.copyProperties(objectDto, object);
        return object;
    }

    public static PassiveAccountDto entityToDto(PassiveAccount passiveAccount)
    {
        PassiveAccountDto objectDto = new PassiveAccountDto();
        BeanUtils.copyProperties(passiveAccount, objectDto);
        return objectDto;
    }

    public static PassiveAccount dtoToEntity(PassiveAccountDto passiveAccountDto)
    {
        PassiveAccount object = new PassiveAccount();
        BeanUtils.copyProperties(passiveAccountDto, object);
        return object;
    }
}
