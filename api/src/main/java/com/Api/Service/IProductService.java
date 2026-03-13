package com.Api.Service;

import com.Api.DTOs.ProductDto;

import java.util.List;

public interface IProductService {

    //CRUD
    //Create
    ProductDto CreateProduct(ProductDto productDto);

    //Read
    List<ProductDto> getProducts();

    //Update
    ProductDto UpdateProduct(Long id, ProductDto productDto);

    //Delete
    void DeleteProduct(Long id);

}
