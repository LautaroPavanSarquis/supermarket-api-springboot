package Prueba.Tecnica.Supermercado.Java.Spring.Boot.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String state;
    private Double total;

    @ManyToOne
    private Branch branch;

    @OneToMany(mappedBy = "venta")
    private List<SaleDetail> detail =  new ArrayList<>();
}
