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
    private Integer quantity;
    private Double price;
    private String category;
}
