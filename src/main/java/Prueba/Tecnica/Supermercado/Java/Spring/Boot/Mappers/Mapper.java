package Prueba.Tecnica.Supermercado.Java.Spring.Boot.Mappers;

import Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs.BranchDto;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs.ProductDto;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs.SaleDetailDto;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs.SaleDto;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Model.Branch;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Model.Product;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Model.Sale;

import java.util.stream.Collectors;

public class Mapper {

    //Product to ProductDTO
    public static ProductDto toDto(Product product) {

        if (product == null) {return null;}

        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    //Sale to saleDTO
    public static SaleDto toDto(Sale sale) {
        if (sale == null) {return null;}

        var detail = sale.getDetail().stream()
                .map( det -> SaleDetailDto.builder()
                        .id(det.getId())
                        .productName(det.getProd().getName())
                        .productQuantity(det.getProductQuantity())
                        .price(det.getPrice())
                        .subTotal(det.getPrice()*det.getProductQuantity())
                        .build()
                ).collect(Collectors.toList());

        var total = detail.stream()
                .map(SaleDetailDto::getSubTotal)
                .reduce(0.0 , Double::sum);


        return SaleDto.builder()
                .id(sale.getId())
                .date(sale.getDate())
                .branchId(sale.getBranch().getId())
                .state(sale.getState())
                .detail(detail)
                .total(sale.getTotal())
                .build();
    }

    //Branch to BranchDTO
    public static BranchDto toDto(Branch branch) {
        if (branch == null) {return null;}

        return BranchDto.builder()
                .id(branch.getId())
                .name(branch.getName())
                .address(branch.getAddress())
                .build();
    }

}
