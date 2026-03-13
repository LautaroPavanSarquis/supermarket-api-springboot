package com.Api.Service;

import com.Api.DTOs.ProductDto;
import com.Api.Exception.NotFoundException;
import com.Api.Mappers.Mapper;
import com.Api.Model.Product;
import com.Api.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    //Dependency Injection
    @Autowired
    private ProductRepository productRepository;


    //CRUD
    @Override
    public ProductDto CreateProduct(ProductDto productDto) {

        var prod = Product.builder()
                .name(productDto.getName())
                .category(productDto.getCategory())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build();

        return Mapper.toDto(productRepository.save(prod));
    }

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(Mapper::toDto)
                .toList();

    }

    @Override
    public ProductDto UpdateProduct(Long id, ProductDto productDto) {


        //Search
        Optional<Product> product = Optional.of(productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found")));

        //Mod
        product.get().setName(productDto.getName());
        product.get().setCategory(productDto.getCategory());
        product.get().setPrice(productDto.getPrice());
        product.get().setQuantity(productDto.getQuantity());


        return Mapper.toDto(productRepository.save(product.get()));
    }

    @Override
    public void DeleteProduct(Long id) {

        //Search
        Optional<Product> product = Optional.of(productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found")));

        //Delete
        productRepository.deleteById(id);

    }
}
