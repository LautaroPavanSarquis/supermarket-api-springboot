package Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchDto {

    private Long id;
    private String name;
    private String address;


}
