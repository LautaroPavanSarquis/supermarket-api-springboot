package Prueba.Tecnica.Supermercado.Java.Spring.Boot.Service;

import Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs.BranchDto;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Model.Branch;

import java.util.List;

public interface IBranchService  {

    //CRUD
    //Create
    BranchDto CreateBranch(BranchDto BranchDto);

    //Read
    List<BranchDto> getBranches();

    //Update
    BranchDto UpdateBranch(Long id, BranchDto BranchDto);

    //Delete
    void DeleteBranch(Long id);

}
