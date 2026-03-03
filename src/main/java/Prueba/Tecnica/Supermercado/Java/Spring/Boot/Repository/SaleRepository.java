package Prueba.Tecnica.Supermercado.Java.Spring.Boot.Repository;

import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {
}
