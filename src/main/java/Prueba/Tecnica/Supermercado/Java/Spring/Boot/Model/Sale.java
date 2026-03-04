package Prueba.Tecnica.Supermercado.Java.Spring.Boot.Model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String state;
    private Double total;

    @ManyToOne
    private Branch branch;

    @OneToMany(mappedBy = "sale", cascade =CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<SaleDetail> detail =  new ArrayList<>();
}
