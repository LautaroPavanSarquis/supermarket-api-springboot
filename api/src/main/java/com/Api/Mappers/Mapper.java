package com.Api.Mappers;

import com.Api.DTOs.BranchDto;
import com.Api.DTOs.ProductDto;
import com.Api.DTOs.SaleDetailDto;
import com.Api.DTOs.SaleDto;
import com.Api.Model.Branch;
import com.Api.Model.Product;
import com.Api.Model.Sale;

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