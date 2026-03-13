package com.Api.Controller;

import com.Api.DTOs.SaleDto;
import com.Api.Service.ISaleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sale")
public class SaleController {

    //Dependency injection
    @Autowired
    private ISaleService saleService;

    //CRUD
    //Create
    @PostMapping
    public ResponseEntity<SaleDto> createSale(@RequestBody SaleDto Sale){

        saleService.CreateSale(Sale);

        return ResponseEntity.ok().body(Sale);
    }

    //Read
    //Get all
    @GetMapping
    public ResponseEntity<List<SaleDto>> getAllSales() {

        return ResponseEntity.ok(saleService.getSales());
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<SaleDto> updateSale(@PathVariable Long id,@RequestBody SaleDto sale){
        return ResponseEntity.ok(saleService.UpdateSale(id, sale));
    }

    //Delete
    @DeleteMapping
    public ResponseEntity<SaleDto> deleteSale(@RequestParam Long id) {
        saleService.DeleteSale(id);

        return ResponseEntity.ok().build();
    }
}
