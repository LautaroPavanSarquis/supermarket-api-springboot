package Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDetailDto {

        private Long id;
        private String productName;
        private Integer productQuantity;
        private Double price;
        private Double subTotal;
}

