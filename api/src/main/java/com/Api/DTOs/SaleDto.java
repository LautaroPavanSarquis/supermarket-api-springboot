package com.Api.DTOs;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDto {

    //Sale Data
    private Long id;
    private LocalDate date;
    private String state;
    private Double total;

    //Branch data
    private Long branchId;

    //Detail data
    private List<SaleDetailDto> detail;



}
