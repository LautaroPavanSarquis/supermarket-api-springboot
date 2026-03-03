package Prueba.Tecnica.Supermercado.Java.Spring.Boot.Repository;

import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch,Long> {
}
