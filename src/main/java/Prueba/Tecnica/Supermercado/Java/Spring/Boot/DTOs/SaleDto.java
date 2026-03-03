package Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDto {

    //Datos Venta
    private Long id;
    private LocalDate date;
    private String state;
    private Double total;

    //datos Sucursal
    private Long branchId;

    //Datos Detalle
    private List<SaleDetailDto> detail;

    //Total de la venta
    private Double Total;


}
