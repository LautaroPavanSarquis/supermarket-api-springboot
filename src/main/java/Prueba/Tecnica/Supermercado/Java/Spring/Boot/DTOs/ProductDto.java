package Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {


    private Long id;
    private String name;
    private String category;
    private Double price;
    private Integer quantity;
}
