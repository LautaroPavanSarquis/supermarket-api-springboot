package Prueba.Tecnica.Supermercado.Java.Spring.Boot.Service;

import Prueba.Tecnica.Supermercado.Java.Spring.Boot.DTOs.BranchDto;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Exception.NotFoundException;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Mappers.Mapper;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Model.Branch;
import Prueba.Tecnica.Supermercado.Java.Spring.Boot.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService implements IBranchService {

    //Dependency Injection
    @Autowired
    private BranchRepository branchRepository;

    //CRUD
    @Override
    public BranchDto CreateBranch(BranchDto BranchDto) {

        var branch = Branch.builder()
                .name(BranchDto.getName())
                .address(BranchDto.getAddress())
                .build();

        return Mapper.toDto(branchRepository.save(branch));
    }

    @Override
    public List<BranchDto> getBranches() {

        return branchRepository.findAll().stream()
                .map(Mapper::toDto)
                .toList();
    }

    @Override
    public BranchDto UpdateBranch(Long id, BranchDto BranchDto) {
        //Search
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() ->new NotFoundException("Branch not found"));

        //Mod
        branch.setName(BranchDto.getName());
        branch.setAddress(BranchDto.getAddress());

        return Mapper.toDto(branchRepository.save(branch));
    }


    @Override
    public void DeleteBranch(Long id) {
        //Search
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() ->new NotFoundException("Branch not found"));

        branchRepository.delete(branch);
    }
}
