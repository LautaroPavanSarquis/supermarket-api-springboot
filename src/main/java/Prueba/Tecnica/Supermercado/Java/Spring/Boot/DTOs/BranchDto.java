package Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs;

import jakarta.persistence.Entity;
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
