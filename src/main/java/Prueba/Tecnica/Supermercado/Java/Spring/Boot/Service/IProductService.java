package Prueba.Tecnica.Supermercado.Java.Spring.Boot.Service;

import Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs.BranchDto;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs.ProductDto;

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
