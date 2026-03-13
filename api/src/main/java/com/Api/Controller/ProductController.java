package com.Api.Controller;

import com.Api.DTOs.ProductDto;
import com.Api.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    //Dependency injection
    @Autowired
    private IProductService productService;

    //CRUD
    //Create
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product) {
        productService.CreateProduct(product);

        return ResponseEntity.ok().body(product);
    }


    //Read
    //Get all
    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {

        return ResponseEntity.ok(productService.getProducts());
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id,@RequestBody ProductDto product) {

        return ResponseEntity.ok(productService.UpdateProduct(id, product));
    }

    //Delete
    @DeleteMapping
    public ResponseEntity<ProductDto> deleteProduct(@RequestParam Long id) {

        productService.DeleteProduct(id);

        return ResponseEntity.notFound().build();
    }
}
