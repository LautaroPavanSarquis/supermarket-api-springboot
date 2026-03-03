package Prueba.Tecnica.Supermercado.Java.Spring.Boot.Service;

import Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs.SaleDto;

import java.util.List;

public interface ISaleService {

    //CRUD
    //Create
    SaleDto CreateSale(SaleDto saleDto);

    //Read
    List<SaleDto> getSales();

    //Update
    SaleDto UpdateSale(Long id, SaleDto saleDto);

    //Delete
    void DeleteSale(Long id);

}
